package com.example.qiany.commonproject.bean;

import java.util.List;

/**
 * @author caiwenqing
 * @data 2018/5/12
 * description:文章描述bean
 */
public class ArticleBean {

    private int curPage;

    private int offset;

    private boolean over;

    private int pageCount;

    private int size;

    private int total;

    private List<Article> datas;

    public int getCurPage() {
        return curPage;
    }

    public void setCurPage(int curPage) {
        this.curPage = curPage;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public boolean isOver() {
        return over;
    }

    public void setOver(boolean over) {
        this.over = over;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<Article> getDatas() {
        return datas;
    }

    public void setDatas(List<Article> datas) {
        this.datas = datas;
    }


    private class Article {

        private String title;

        private String author;

        //发布时间
        private String niceDate;

        private int id;

        private String link;
    }

    @Override
    public String toString() {
        return "ArticleBean{" +
                "curPage=" + curPage +
                ", offset=" + offset +
                ", over=" + over +
                ", pageCount=" + pageCount +
                ", size=" + size +
                ", total=" + total +
                ", datas=" + datas +
                '}';
    }
}
