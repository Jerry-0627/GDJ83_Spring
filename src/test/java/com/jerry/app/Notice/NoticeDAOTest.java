package com.jerry.app.Notice;

import java.sql.Date;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.jerry.app.DefaultTest;
import com.jerry.app.notice.NoticeDAO;
import com.jerry.app.notice.NoticeDTO;

public class NoticeDAOTest extends DefaultTest {

	@Autowired
	private NoticeDAO noticeDAO;

	@Test
	public void NoticeTest() throws Exception {
		NoticeDTO noticeDTO = new NoticeDTO();
		for (long i = 0; i < 100; i++) {
			Date date = new Date(i);
			noticeDTO.setBoard_num(i);
			noticeDTO.setBoard_writer("작성자" + i);
			noticeDTO.setBoard_title("제목" + (i * 2));
			noticeDTO.setCreate_date(date);
			i = i + 1;
			noticeDTO.setUpdate_date(date);
			int r = ((int) (Math.random() * 1000)) / 100;
			noticeDTO.setBoard_hit(r);
			noticeDTO.setBoard_contents("랜덤" + (r * r));
			noticeDTO.setBoard_category("1");

		}

//			ProductDTO productDTO = new ProductDTO();
//			for (int i = 0; i < 100; i++) {
//				productDTO.setProduct_name("자유입출금" + i);
//				double r = ((int) (Math.random() * 1000)) / 100.0;
//				productDTO.setProduct_rate(r);
//				productDTO.setProduct_ex("상세설명" + i);
//				productDAO.doadd(productDTO);
//				Thread.sleep(500);
//			}
//			System.out.println("Finish");

	}
}
