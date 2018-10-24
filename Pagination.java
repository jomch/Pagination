
// SpringMVC Pagination v1.0

public class Pagination {
	
	private String urlTpl = "";
	
	private int totalRows = 200;
	
	private int perPage = 20;
	
	private int curPage = 5;
	
	private int numLinks = 2;
	
	// 分页总标签
	private String fullTagOpen = "<ul>";
	private String fullTagClose = "</ul>";
	
	// 头页标签
	private String firstLink = "&lt;&lt";
	private String firstTagOpen = "<li>";
	private String firstTagClose = "</li>";
	
	// 末页标签
	private String lastLink = "&gt;&gt;";
	private String lastTagOpen = "<li>";
	private String lastTagClose = "</li>";
	
	// 下一页标签
	private String nextLink = "&gt;";
	private String nextTagOpen = "<li>";
	private String nextTagClose = "</li>";
	
	// 上一页标签
	private String prevLink = "&lt;";
	private String prevTagOpen = "<li>";
	private String prevTagClose = "</li>";
	
	// 当前页标签
	private String curTagOpen = "<li>";	
	private String curTagClose = "</li>";
	
	// 页码标签
	private String numTagOpen = "<li>";
	private String numTagClose = "</li>";	
	
	/*
		url模板
		eg. /user/list/99 => /user/list/{page}
		eg. /search?query=abc&page={page}
	*/	
	public void setUrlTpl(String _urlTpl) {
		this.urlTpl = _urlTpl;
	}

	// 总记录数
	public void setTotalRows(int _totalRows) {
		this.totalRows = _totalRows;
	}
	
	// 每页显示
	public void setPerPage(int _perPage) {
		this.perPage = _perPage;
	}

	// 当前页
	public void setCurPage(int _curPage) {
		this.curPage = _curPage;
	}

	// 当前页的两边Link个数
	public void setNumLinks(int _numLinks) {
		this.numLinks = _numLinks;
	}

	// 获取Url实体
	public String getUrlEntity(int page) {
		return this.urlTpl.replace( "{page}", String.valueOf(page) );
	}
	
	public String createLinks() {
		
		
		if( totalRows==0 || perPage==0 ) {
			return "";
		}
		
		int numPages = (int) Math.ceil( totalRows/perPage );
		
		if( numPages == 1 ) {
			return "";
		}
		
		int pageStart = (curPage-numLinks) > 0 ? curPage-numLinks : 1; 
		int pageEnd = (curPage+numLinks) < numPages ? curPage+numLinks : numPages;
		
		String output = "";
		
		// 头页
		if( curPage > 1) {
			output += firstTagOpen+"<a href=\""+getUrlEntity(1)+"\">"+firstLink+"</a>"+firstTagClose;
		}
		
		// 上一页
		if( curPage > 1 ) {
			output += prevTagOpen+"<a href=\""+getUrlEntity(curPage-1)+"\">"+prevLink+"</a>"+prevTagClose;
		}
		
		// 页码
		for(int i=pageStart; i<=pageEnd; i++) {
			if( i == curPage ) {
				output += curTagOpen + "<span>" + i + "</span>" + curTagClose;
			} else {
				output += numTagOpen+"<a href=\""+getUrlEntity(i)+"\">"+i+"</a>"+numTagClose;
			}
		}
		
		// 下一页
		if( curPage < numPages ) {
			output += nextTagOpen+"<a href=\""+getUrlEntity(curPage+1)+"\">"+nextLink+"</a>"+nextTagClose;
		}
		
		// 尾页
		if( curPage+numLinks < numPages ) {
			output += lastTagOpen+"<a href=\""+getUrlEntity(numPages)+"\">"+lastLink+"</a>"+lastTagClose;
		}
		
		return fullTagOpen+output+fullTagClose;
		
	}
	
}