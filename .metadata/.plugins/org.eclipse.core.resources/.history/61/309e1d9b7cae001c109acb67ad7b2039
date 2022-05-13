package com.verinite.bookstore.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.verinite.bookstore.entity.Book;
import com.verinite.bookstore.entity.Registration;

@Repository
public interface BookRepository extends JpaRepository<Book,Integer> {

	@Query(value="select * from tbl_book where is_deleted=false", nativeQuery = true)
    List<Book> getAllBook(boolean isDelete);
	
	@Query(value="select b.book_id,b.book_title,b.description,b.book_price,b.pic_byte,s.stock_id,s.quantity from tbl_book b inner join stock s on b.book_id=s.book_id",nativeQuery = true)
	List<Map<String, String>> getAllDataOfBookWithStockDeatails();
	@Query(value="select b.book_id,b.book_title,b.description,b.book_price,b.pic_byte ,c.category_title,a.first_name ,a.last_name,p.publisher_name from tbl_book b inner join tbl_category c on c.category_id=b.category_id inner join tbl_author a on a.author_id=b.author_id inner join tbl_publisher p on p.publisher_id=b.publisher_id and b.book_id=?1 ",nativeQuery = true)
	List<Map<String, String>> findBookById(int bookId);

}
