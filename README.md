# Pagination
**SpringMVC Pagination v1.0
**##一个简单易用的SpringMVC分页类，参考Codeigniter Pagination写的。

**Controller
```
Pagination Pgn = new Pagination();
Pgn.setUrlTpl("/news/list/{page}");
Pgn.setCurPage(5);
Pgn.setPerPage(10);
Pgn.setTotalRows(100);
```

**View

把Style.css里面的内容Copy到View中
