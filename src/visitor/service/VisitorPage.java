package visitor.service;

import java.util.List;

import visitor.model.Visitor;

public class VisitorPage {
	private int total;
	private int currentPage;
	private List<Visitor> content;
//	private List<VisitorRequest> contentname;
	private List<String> name;
	private int totalPages;
	private int startPage;
	private int endPage;
	
	public VisitorPage(int total, int currentPage, int size, List<Visitor> content, List<String> name) {
		this.total = total;
		this.currentPage = currentPage;
		this.content = content;
		this.name = name;
//		this.name = name; // 새로 추가한부분
		if(total == 0) {
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
			if(modVal == 0) {
				startPage -= 5;
			}
			endPage = startPage + 4;
			if(endPage > totalPages) {
				endPage = totalPages;
			}
		}
	}
	
//	public VisitorPage(int total, int currentPage, int size, List<VisitorRequest> content) {
//		this.total = total;
//		this.currentPage = currentPage;
//		this.contentname = content;
//		if(total == 0) {
//			totalPages = 0;
//			startPage = 0;
//			endPage = 0;
//		} else {
//			totalPages = total / size;
//			if(total % size > 0) {
//				totalPages++;
//			}
//			int modVal = currentPage % 5;
//			startPage = currentPage / 5 * 5 + 1;
//			if(modVal == 0) {
//				startPage -= 5;
//			}
//			endPage = startPage + 4;
//			if(endPage > totalPages) {
//				endPage = totalPages;
//			}
//		}
//	}
	
	public boolean hasVisitor() {
		return total > 0;
	}
	

	public List<String> getName() {
		return name;
	}

	public boolean hasNoVisitor() {
		return total == 0;
	}

	public int getTotal() {
		return total;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public List<Visitor> getContent() {
		return content;
	}
	
	public int getTotalPages() {
		return totalPages;
	}

	public int getStartPage() {
		return startPage;
	}

	public int getEndPage() {
		return endPage;
	}

//	public List<VisitorRequest> getContentname() {
//		return contentname;
//	}
	
	
	
}
