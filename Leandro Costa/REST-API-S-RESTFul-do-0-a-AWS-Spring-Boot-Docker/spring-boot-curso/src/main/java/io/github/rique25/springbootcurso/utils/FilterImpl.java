package io.github.rique25.springbootcurso.utils;

import io.github.rique25.springbootcurso.enuns.FilterType;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class FilterImpl {

    private List<FilterQueryImpl> filter;
    private Integer page;
    private Integer size;
    private String order;

    public static FilterImpl parse(String filter, Integer page, Integer size, String order) {
        List<FilterQueryImpl> queries = new ArrayList<>();
        if (filter != null && !filter.isEmpty()) {
            String[] filters = filter.split(" AND ");
            for (String fs: filters) {
                FilterQueryImpl filterQuery = new FilterQueryImpl();

                String[] fss = fs.split(" ");
                String right = "";
                for (int i = 2; i < fss.length; i++) {
                    if (i != fss.length - 1) {
                        right += fss[i] + " ";
                    } else {
                        right += fss[i];
                    }
                }

                filterQuery.setField(fss[0]);
                filterQuery.setType(FilterType.valueOf(fss[1]));

                boolean settedValue = false;

                try {
                    filterQuery.setLongValue(Long.parseLong(right));
                    settedValue = true;
                } catch (NumberFormatException ex) {

                }

                if (!settedValue && ("true".equals(right) || "false".equals(right))) {
                    filterQuery.setBooleanValue(Boolean.valueOf(right));
                    settedValue = true;
                }

                if (!settedValue) {
                    try {
                        if (right.endsWith("Z")) {
                            right = right.replace("Z", "+00:00");
                        }
                        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
                        filterQuery.setDateValue(dateFormat.parse(right));
                        settedValue = true;
                    } catch (ParseException e) {
                        right = right.replace("+00:00", "Z");
                    }
                }

                if (!settedValue) {
                    filterQuery.setStringValue(right);
                }

                queries.add(filterQuery);
            }
        }
        return new FilterImpl(queries, page, size, order);
    }

    public FilterImpl(List<FilterQueryImpl> filter, Integer page, Integer size, String order) {
        this.filter = filter;
        this.page = page;
        this.size = size;
        this.order = order;
    }

    public List<FilterQueryImpl> getFilter() {
        return filter;
    }

    public void setFilter(List<FilterQueryImpl> filter) {
        this.filter = filter;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }
}
