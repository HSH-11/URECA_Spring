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



	// 주문하기
	document.querySelector("#orderForm").onsubmit = async function(e) {
		e.preventDefault();

		const productId = document.querySelector("#orderProductId").value;
		const quantity = parseInt(document.querySelector("#orderQuantity").value);
		const address = document.querySelector("#orderAddress").value;
		const totalText = document.querySelector("#orderTotal").value.replace(/[^0-9]/g, "");
		const totalAmount = parseInt(totalText);

		const response = await fetch("/orders/insert", {
			method: "POST",
			headers: { "Content-Type": "application/json" },
			body: JSON.stringify({ productId, quantity, shippingAddress: address, totalAmount })
		});

		const result = await response.json();
		if (result.result === "success") {
			alertify.success("주문이 완료되었습니다!");
			bootstrap.Modal.getInstance(document.getElementById("orderModal")).hide();
		} else {
			alertify.error("주문 실패. 다시 시도해주세요.");
		}
	};






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
        <button class="btn btn-sm btn-outline-success" title="구매" onclick="buyProduct(${product.productId})">
          <i class="bi bi-cart"></i>
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

async function buyProduct(productId) {
	let fetchOptions = { headers: { ajax: "true" } };
	const res = await fetch(`/products/detail/${productId}`, fetchOptions);
	const product = await res.json();
	setOrderForm(product);
}


function setOrderForm(product) {
	document.querySelector("#orderProductId").value = product.productId;
	document.querySelector("#orderProductName").value = product.name;
	document.querySelector("#orderQuantity").value = 1;
	document.querySelector("#orderTotal").value = product.price.toLocaleString() + "원";
	document.querySelector("#orderAddress").value = "";

	// 수량 변경 시 총액 자동 변경
	document.querySelector("#orderQuantity").oninput = () => {
		const quantity = parseInt(document.querySelector("#orderQuantity").value);
		const total = product.price * quantity;
		document.querySelector("#orderTotal").value = total.toLocaleString() + "원";
	};

	new bootstrap.Modal(document.getElementById('orderModal')).show();
}

