package owner.service;

import java.util.List;

import owner.model.Owner;

public class OwnerPage {
	private int total;
	private int currentPage;
	private List<Owner> comment;
	private int totalPages;
	private int startPage;
	private int endPage;
	
	public OwnerPage(int total, int currentPage, int size, List<Owner> comment) {
		this.total = total;
		this.currentPage = currentPage;
		this.comment = comment;
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
	
	public boolean hasOwner() {
		return total > 0;
	}
	
	public boolean hasNoOwner() {
		return total == 0;
	}

	public int getTotal() {
		return total;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public List<Owner> getComment() {
		return comment;
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

	
}
