package photo.service;

import java.util.List;

import photo.model.Photo;

//게시글 목록을 제공하는 서비스구현
public class PhotoPage {
	private int total;
	private int currentPage;
	private List<Photo> content;
	private int totalPages;
	private int startPage;
	private int endPage;
	
	public PhotoPage(int total, int currentPage, int size, List<Photo> content) {
		this.total = total;
		this.currentPage = currentPage;
		this.content = content;
		
		if(total == 0 ) {
			totalPages = 0;
			startPage = 0;
			endPage = 0;
			
		} else {
			totalPages = total / size;
			if(total % size > 0) {
				totalPages++;
			}
			int modVal = currentPage % 5;
			startPage = currentPage / 5 * 5 + 1;
			
			if (modVal == 0) startPage -= 5;
			
			endPage = startPage + 4;
			if(endPage > totalPages) endPage = totalPages;
		}
	}
	public int getTotal() {
		return total;
	}
	public boolean hasNoPhoto() {
		return total == 0;
	}
	public boolean hasPhoto() {
		return total > 0;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public int getTotalPages() {
		return totalPages;
	}
	public List<Photo> getContent() {
		return content;
	}
	public int getStartPage() {
		return startPage;
	}
	public int getEndPage() {
		return endPage;
	}

}
