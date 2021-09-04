package com.meeting.meeting_server.pojo.query;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PageQuery {
    protected Integer page;
    protected Integer rows;
    /**
     * 自动计算字段，用于dao的偏移量
     */
    protected Integer start;

    public PageQuery(Integer page, Integer rows) {
        this.page = page;
        this.rows = rows;
        this.start = page*rows;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page-1;
        if (start==null){
            this.start=page.intValue();
        }else {
            this.start=page*rows;
        }
    }

    public Integer getRows() {
        return rows;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
        if (start==null){
            this.start=page.intValue();
        }else {
            this.start=page*rows;
        }
    }

    /**
     * 用于生成子类使用
     * @param pageQuery
     */
    public void setByPageQuery(PageQuery pageQuery) {
        this.setPage(pageQuery.getPage());
        this.setRows(pageQuery.getRows());
    }
}

