let LIST_ROW_COUNT = 10;
let OFFSET = 0;
let TOTAL_LIST_COUNT = 0;
let SEARCH_WORD = '';
let CURRENT_PAGE = 1;

window.onload = function() {
	// 상품 목록
	listProduct();

	// 검색어 목록
	document.querySelector("#btnSearchWord").onclick = function() {
		SEARCH_WORD = document.querySelector("#inputSearchWord").value;
		OFFSET = 0;
		CURRENT_PAGE = 1;
		listProduct();
	}


	document.querySelector("#editProductForm").addEventListener("submit", async function(e) {
		e.preventDefault();

		const productId = document.querySelector("#editProductId").value;
		const productName = document.querySelector("#editProductName").value;
		const productPrice = document.querySelector("#editProductPrice").value;
		const productStock = document.querySelector("#editProductStock").value;

		// 서버로 수정된 상품 정보 전송
		const response = await fetch(`/products/update/${productId}`, {
			method: "PUT",
			headers: {
				"Content-Type": "application/json"
			},
			body: JSON.stringify({
				productId,
				name: productName,
				price: productPrice,
				stock: productStock
			})
		});
		
		const result = await response.json();
		if (result.result === "success") {
			alertify.success("상품이 수정되었습니다!");
			bootstrap.Modal.getInstance(document.getElementById("editProductModal")).hide();
			listProduct(); // 수정 후 목록 갱신
		} else {
			alertify.error("수정 실패. 다시 시도해주세요.");
		}
	});



};

async function listProduct() {
	const url = "/products/list";
	const urlParams = `?limit=${LIST_ROW_COUNT}&offset=${OFFSET}&searchWord=${SEARCH_WORD}`;
	let fetchOptions = {
		headers: {
			"ajax": "true"
		}
	}

	const response = await fetch(url + urlParams, fetchOptions);
	const data = await response.json();
	console.log(data);

	if (data.result === "success") {
		makeProductListHtml(data.list);
		TOTAL_LIST_COUNT = data.count;
		makePagination();
	} else if (data.result === "fail") {
		document.querySelector("#productTBody").innerHTML = `<tr><td colspan="5">목록을 불러올 수 없습니다.</td></tr>`;
	} else if (data.result === "login") {
		window.location.href = "/index.html";
	}
}

function makeProductListHtml(list) {
	let html = "";


	list.forEach(product => {
		html += `
      <tr>
        <td>${product.productId}</td>
        <td>${product.name}</td>
        <td>${product.price.toLocaleString()}원</td>
        <td>${product.stock}</td>
        <td>
        <button class="btn btn-sm btn-outline-warning me-1" title="수정" onclick="editProduct(${product.productId})">
          <i class="bi bi-pencil"></i>
        </button>
        <button class="btn btn-sm btn-outline-danger" title="삭제" onclick="deleteProduct(${product.productId})">
          <i class="bi bi-trash"></i>
        </button>
		</td></tr>`;
	});

	document.querySelector("#productTBody").innerHTML = html;
}

function makePagination() {
	const pagination = document.querySelector("#pagination");
	pagination.innerHTML = "";

	const totalPages = Math.ceil(TOTAL_LIST_COUNT / LIST_ROW_COUNT);

	for (let i = 1; i <= totalPages; i++) {
		let li = document.createElement("li");
		li.className = `page-item ${i === CURRENT_PAGE ? 'active' : ''}`;

		let a = document.createElement("a");
		a.className = "page-link";
		a.innerText = i;
		a.href = "#";
		a.onclick = function() {
			CURRENT_PAGE = i;
			OFFSET = (i - 1) * LIST_ROW_COUNT;
			listProduct();
		};

		li.appendChild(a);
		pagination.appendChild(li);
	}
}



async function editProduct(productId) {
	// 상품 정보를 가져오기 위한 fetch 요청
	let fetchOptions = { headers: { "ajax": "true" } };
	const res = await fetch(`/products/detail/${productId}`, fetchOptions);
	const product = await res.json();

	// 수정 폼에 값 채우기
	document.querySelector("#editProductId").value = product.productId;
	document.querySelector("#editProductName").value = product.name;
	document.querySelector("#editProductPrice").value = product.price;
	document.querySelector("#editProductStock").value = product.stock;

	// 수정 폼을 띄우는 부분
	new bootstrap.Modal(document.getElementById('editProductModal')).show();
}

function deleteProduct(productId) {
	if (confirm("이 상품을 삭제하시겠습니까?")) {
		alert("삭제 기능은 아직 미구현입니다.\n상품 ID: " + productId);
	}
}
