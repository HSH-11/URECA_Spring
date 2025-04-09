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
	
<script src="//cdn.jsdelivr.net/npm/alertifyjs@1.14.0/build/alertify.min.js"></script>
<link rel="stylesheet" href="//cdn.jsdelivr.net/npm/alertifyjs@1.14.0/build/css/alertify.min.css"/>
<link rel="stylesheet" href="//cdn.jsdelivr.net/npm/alertifyjs@1.14.0/build/css/themes/bootstrap.min.css"/>
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
		<nav>
			<ul id="pagination" class="pagination justify-content-center"></ul>
		</nav>

		<div class="d-flex justify-content-end">
			<a href="/admin/product/addForm" class="btn btn-primary">+ 상품 추가</a>
		</div>
	</div>

	<!-- 상품 수정 Modal -->
	<div class="modal fade" id="editProductModal" tabindex="-1"
		aria-labelledby="editProductModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="editProductModalLabel">상품 수정</h5>
					<button type="button" class="btn-close" data-bs-dismiss="modal"
						aria-label="Close"></button>
				</div>
				<div class="modal-body">
					<form id="editProductForm">
						<div class="mb-3">
							<label for="editProductId" class="form-label">상품 ID</label> <input
								type="text" class="form-control" id="editProductId" readonly>
						</div>
						<div class="mb-3">
							<label for="editProductName" class="form-label">상품명</label> <input
								type="text" class="form-control" id="editProductName">
						</div>
						<div class="mb-3">
							<label for="editProductPrice" class="form-label">가격</label> <input
								type="number" class="form-control" id="editProductPrice">
						</div>
						<div class="mb-3">
							<label for="editProductStock" class="form-label">재고</label> <input
								type="number" class="form-control" id="editProductStock">
						</div>
						<button type="submit" class="btn btn-primary">수정 완료</button>
					</form>
				</div>
			</div>
		</div>
	</div>


	<script src="/js/adminProduct.js"></script>
	
</body>
</html>
