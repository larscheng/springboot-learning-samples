package com.larscheng.www.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * The type Page param.
 *
 * @Package Name : com.senthink.www.domain.param
 * @Class Name : ${CLASS_NAME}
 * @ModificationHistory Who When What -------- ----------
 *                      -----------------------------------
 */
//@ApiModel(value = "分页高级查询通用参数实体")
public class PageVo{

	private Integer id;
	@ApiModelProperty(value = "当前页码",required = true)
	private int page = 1;

	@ApiModelProperty(value = "每页条目，默认10",required = true)
	private int pageSize = 10;

	@ApiModelProperty("模糊查询")
	private String search;

	@ApiModelProperty("开始显示的行数，默认第一行")
	private int offset=0;

	@ApiModelProperty("查询时间起始")
	private String searchBgnTime;

	@ApiModelProperty("时间结束")
	private String searchEndTime;

	@ApiModelProperty("排序")
	private String sort;

	/**
	 * Gets search end time.
	 *
	 * @return the search end time
	 */
	public String getSearchEndTime() {
		return searchEndTime;
	}

	/**
	 * Sets search end time.
	 *
	 * @param searchEndTime
	 *            the search end time
	 */
	public void setSearchEndTime(String searchEndTime) {
		this.searchEndTime = searchEndTime;
	}

	public int getPage() {
		return page;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getOffset() {
		return offset;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

	public String getSearchBgnTime() {
		return searchBgnTime;
	}

	public void setSearchBgnTime(String searchBgnTime) {
		this.searchBgnTime = searchBgnTime;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

}
