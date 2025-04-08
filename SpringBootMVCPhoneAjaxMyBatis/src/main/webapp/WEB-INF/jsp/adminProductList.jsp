<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css">
<title>휴대폰 목록</title>
</head>
<body>
	<div class="container mt-5">
		<h2 class="mb-4 text-center">📱 휴대폰 목록</h2>

		<!-- 검색 기능 -->
		<div class="input-group mb-3">
			<input type="text" class="form-control" id="inputSearchWord"
				placeholder="상품명을 입력하세요">
			<button class="btn btn-outline-secondary" type="button"
				id="btnSearchWord">검색</button>
		</div>

		<!-- 상품 목록 -->
		<table
			class="table table-bordered table-hover text-center align-middle">
			<thead class="table-light">
				<tr>
					<th>상품 ID</th>
					<th>상품명</th>
					<th>가격</th>
					<th>재고</th>
					<th>관리</th>
				</tr>
			</thead>
			<tbody id="productTBody">

			</tbody>
		</table>

		<div class="d-flex justify-content-end">
			<a href="/admin/product/addForm" class="btn btn-primary">+ 상품 추가</a>
		</div>
	</div>

	<script>
		let LIST_ROW_COUNT = 10;
		let OFFSET = 0;
		let TOTAL_LIST_COUNT = 0;
		let SEARCH_WORD = '';

		window.onload = function() {
			listProduct();

			document.querySelector("#btnSearchWord").onclick = function() {
				SEARCH_WORD = document.querySelector("#inputSearchWord").value;
				console.log("검색어 확인:", SEARCH_WORD);
				OFFSET = 0;
				listProduct();
			}
		}
		
		async function listProduct(){
			const url = "/products/list";
			const urlParams = `?limit=\${LIST_ROW_COUNT}&offset=\${OFFSET}&searchWord=\${SEARCH_WORD}`;
			console.log("요청 URL:", url + urlParams);
		    const response = await fetch(url + urlParams);
		    const data = await response.json();
		    console.log(data);
		    if (data.result === "success") {
		        makeProductListHtml(data.list);
		        TOTAL_LIST_COUNT = data.count;
		        // ✨ 추후 페이징 처리 가능
		      } else {
		        document.querySelector("#productTBody").innerHTML = `<tr><td colspan="5">목록을 불러올 수 없습니다.</td></tr>`;
		      }
		}
		
		function makeProductListHtml(list) {
			  let html = "";

			  list.forEach(product => {
			    html += `
			      <tr>
			        <td>\${product.productId}</td>
			        <td>\${product.name}</td>
			        <td>\${product.price.toLocaleString()}원</td>
			        <td>\${product.stock}</td>
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
		
		function editProduct(productId) {
		    alert("수정 기능은 아직 미구현입니다.\n상품 ID: " + productId);
		  }

		function deleteProduct(productId) {
		    if (confirm("이 상품을 삭제하시겠습니까?")) {
		      alert("삭제 기능은 아직 미구현입니다.\n상품 ID: " + productId);
		      // 삭제 요청은 나중에 구현
		    }
		 }
		
	</script>
</body>
</html>
