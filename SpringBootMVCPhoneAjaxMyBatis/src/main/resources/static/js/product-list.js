let LIST_ROW_COUNT = 10;
let OFFSET = 0;
let TOTAL_LIST_COUNT = 0;
let SEARCH_WORD = '';
let CURRENT_PAGE = 1;

window.onload = function() {
  listProduct();

  document.querySelector("#btnSearchWord").onclick = function() {
    SEARCH_WORD = document.querySelector("#inputSearchWord").value;
    OFFSET = 0;
    CURRENT_PAGE = 1;
    listProduct();
  }
};

async function listProduct() {
  const url = "/products/list";
  const urlParams = `?limit=${LIST_ROW_COUNT}&offset=${OFFSET}&searchWord=${SEARCH_WORD}`;
  const response = await fetch(url + urlParams);
  const data = await response.json();
  console.log(data);

  if (data.result === "success") {
    makeProductListHtml(data.list);
    TOTAL_LIST_COUNT = data.count;
    makePagination();
  } else {
    document.querySelector("#productTBody").innerHTML = `<tr><td colspan="5">목록을 불러올 수 없습니다.</td></tr>`;
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
        </td>
      </tr>
    `;
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
    a.onclick = function () {
      CURRENT_PAGE = i;
      OFFSET = (i - 1) * LIST_ROW_COUNT;
      listProduct();
    };

    li.appendChild(a);
    pagination.appendChild(li);
  }
}


function editProduct(productId) {
  alert("수정 기능은 아직 미구현입니다.\n상품 ID: " + productId);
}

function deleteProduct(productId) {
  if (confirm("이 상품을 삭제하시겠습니까?")) {
    alert("삭제 기능은 아직 미구현입니다.\n상품 ID: " + productId);
  }
}
