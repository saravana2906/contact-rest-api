package com.contact.api.dto;

import lombok.Data;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;


@Data
public class Pageutil  {

    Integer size;

    Integer page;

    String sort;
}
