////
//// Source code recreated from a .class file by IntelliJ IDEA
//// (powered by FernFlower decompiler)
////
//
//package com.example.spring.demo.common.bo;
//
//import com.alibaba.fastjson.JSON;
//import com.alibaba.fastjson.annotation.JSONField;
//import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
//import com.example.spring.demo.common.exception.BizException;
//import com.example.spring.demo.common.exception.BizExceptionCode;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.util.CollectionUtils;
//
//import java.beans.ConstructorProperties;
//import java.io.Serializable;
//import java.util.ArrayList;
//import java.util.List;
//
//public class QueryResult<T> implements Serializable {
//    private static final Logger log = LoggerFactory.getLogger(QueryResult.class);
//    private static final long serialVersionUID = 676226419039421871L;
//    private List<T> list = new ArrayList();
//    private long total;
//    private long pageSize;
//    private long current;
//    private long pages;
//
//    public QueryResult(Object obj) {
//        if (obj instanceof Page) {
//            Page page = (Page)obj;
//            this.current = page.getCurrent();
//            this.pageSize = page.getSize();
//            this.total = page.getTotal();
//            this.list = page.getRecords();
//        } else {
//            if (!(obj instanceof List)) {
//                log.error("obj type:{}", obj.getClass());
//                throw new BizException(BizExceptionCode.QUERY_RESULT_TYPE_CONVERT_ERROR, new String[0]);
//            }
//
//            List list = (List)obj;
//            this.current = 1L;
//            this.pageSize = (long)list.size();
//            this.pages = 1L;
//            this.list = list;
//            this.total = (long)list.size();
//        }
//
//    }
//
//    public long getPages() {
//        if (this.total > 0L && this.total % this.pageSize > 0L) {
//            return this.total / this.pageSize + 1L;
//        } else {
//            return this.total > 0L ? this.total / this.pageSize : 0L;
//        }
//    }
//
//    public QueryResult(Page page, List list) {
//        this.current = page.getCurrent();
//        this.pageSize = page.getSize();
//        this.total = page.getTotal();
//        this.list = list;
//    }
//
//    public static <T> QueryResult convert(Page page, Class<T> cls) {
//        QueryResult queryResult = new QueryResult();
//        queryResult.setCurrent(page.getCurrent());
//        queryResult.setPageSize(page.getSize());
//        queryResult.setTotal(page.getTotal());
//        queryResult.setList(queryResult.copyList(page.getRecords(), cls));
//        return queryResult;
//    }
//
//    public static <T> QueryResult convert(QueryResult page, List<T> list) {
//        QueryResult queryResult = new QueryResult();
//        queryResult.setCurrent(page.getCurrent());
//        queryResult.setPageSize(page.getPageSize());
//        queryResult.setTotal(page.getTotal());
//        queryResult.setList(list);
//        return queryResult;
//    }
//
//    public <T> QueryResult convertRows(Class<T> cls) {
//        this.setList(this.copyList(this.getList(), cls));
//        return this;
//    }
//
//    private <T> List copyList(List list, Class<T> target) {
//        return (List)(CollectionUtils.isEmpty(list) ? new ArrayList() : JSON.parseArray(JSON.toJSONString(list), target));
//    }
//
//    public void setPageNum(int pageNum) {
//        this.current = (long)pageNum;
//    }
//
//    @JSONField(
//        serialize = false
//    )
//    public long getPageNum() {
//        return this.current;
//    }
//
//    public static <T> QueryResult.QueryResultBuilder<T> builder() {
//        return new QueryResult.QueryResultBuilder();
//    }
//
//    public void setList(final List<T> list) {
//        this.list = list;
//    }
//
//    public void setTotal(final long total) {
//        this.total = total;
//    }
//
//    public void setPageSize(final long pageSize) {
//        this.pageSize = pageSize;
//    }
//
//    public void setCurrent(final long current) {
//        this.current = current;
//    }
//
//    public void setPages(final long pages) {
//        this.pages = pages;
//    }
//
//    public List<T> getList() {
//        return this.list;
//    }
//
//    public long getTotal() {
//        return this.total;
//    }
//
//    public long getPageSize() {
//        return this.pageSize;
//    }
//
//    public long getCurrent() {
//        return this.current;
//    }
//
//    @ConstructorProperties({"list", "total", "pageSize", "current", "pages"})
//    public QueryResult(final List<T> list, final long total, final long pageSize, final long current, final long pages) {
//        this.list = list;
//        this.total = total;
//        this.pageSize = pageSize;
//        this.current = current;
//        this.pages = pages;
//    }
//
//    public QueryResult() {
//    }
//
//    public static class QueryResultBuilder<T> {
//        private List<T> list;
//        private long total;
//        private long pageSize;
//        private long current;
//        private long pages;
//
//        QueryResultBuilder() {
//        }
//
//        public QueryResult.QueryResultBuilder<T> list(final List<T> list) {
//            this.list = list;
//            return this;
//        }
//
//        public QueryResult.QueryResultBuilder<T> total(final long total) {
//            this.total = total;
//            return this;
//        }
//
//        public QueryResult.QueryResultBuilder<T> pageSize(final long pageSize) {
//            this.pageSize = pageSize;
//            return this;
//        }
//
//        public QueryResult.QueryResultBuilder<T> current(final long current) {
//            this.current = current;
//            return this;
//        }
//
//        public QueryResult.QueryResultBuilder<T> pages(final long pages) {
//            this.pages = pages;
//            return this;
//        }
//
//        public QueryResult<T> build() {
//            return new QueryResult(this.list, this.total, this.pageSize, this.current, this.pages);
//        }
//
//        public String toString() {
//            return "QueryResult.QueryResultBuilder(list=" + this.list + ", total=" + this.total + ", pageSize=" + this.pageSize + ", current=" + this.current + ", pages=" + this.pages + ")";
//        }
//    }
//}
