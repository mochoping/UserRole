package kh.edu.react.provider.controller;

import kh.edu.react.provider.dto.Product;
import kh.edu.react.provider.service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


// url api endpoint
/*
url = 웹에서 특정 리소스(페이지 , 이미지, API등)에 접근하기 위한 주소
https :// www. kht.com     /api/users/123
프로토콜 구분자 도메인     경로(path)

API = 프로그램간 데이터와 기능을 주고 받을 수 있도록 만든 인터페이스
API 는 여러개의 endpoint (접속지점)을 포함함
API 방식에는 대표적으로 REST API ( = get, post ,put, delete 와 같은 형식으로 데이터 전달, 전송, 수정 , 삭제 )

EndPoint = API에서 특정 작업을 수행하는 URL
예를 들어 아래와 같은 URL(API)가 있다고 가정
http      ://     www. kht .com  /api/users/123

GET / api/users/123 사용자 조회
POST / api/users/123 사용자 생성
PUT / api/users/123 사용자 수정
DELETE / api/users/123 사용자 삭제

음식점으로 비유

식당의 주소가 URL


 */
// api endpoint 명칭 사용

@RestController
@RequestMapping("/api/products")
public class ProductAPIController {

    @Autowired
    private ProductServiceImpl productService;

    //모든제품 조회
    @GetMapping// /api/products
    public List<Product> findAllProducts() {
        return productService.findAllProducts();
    }

    //제품검색 (상품명 또는 카테고리)
    @GetMapping("/search")
    public List<Product> searchProducts(@RequestParam String keyword) {
        return productService.searchProducts(keyword);
    }

    //특정 제품 상세 조회
    @GetMapping("/{productId}")
    public Product findProductById(@PathVariable int productId) {
        return productService.findProductById(productId);
    }

    // 제품저장
    @PostMapping
    public void saveProduct(@RequestBody Product product) {
        productService.saveProduct(product);
    }
}
