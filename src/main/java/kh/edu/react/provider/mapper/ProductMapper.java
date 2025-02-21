package kh.edu.react.provider.mapper;

import kh.edu.react.provider.dto.Product;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductMapper {

    // 접근 제어자는 필수로 작성해야하는 항목이 아님. 인터페이스여서
    // 접근제어자 자료형 mapper.xml 에 작성한 id 명칭
    // 모든 제품 조회
    List<Product> findAllProducts();

    // 제품 검색 (상품명 또는 카테고리)
    List<Product> searchProducts(String keyword);

    // 특정 제품 상세 조회 (ID 기반으로 검색)
    Product findProductById(int productId);

    // 제품 저장
    //               자료형 두가지를 제안 -> void int
    //               자료형을 통해 마지막에 데이터가 들어간 갯수를 확인하고 싶다 -> int
    //               자료형을 통해 리턴을 사용해서 확인할 필요가 없음 -> void
    void saveProduct(Product product);


}
