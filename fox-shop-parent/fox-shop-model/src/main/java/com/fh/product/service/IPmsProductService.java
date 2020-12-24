package com.fh.product.service;

import com.fh.product.entity.PmsProduct;
import com.baomidou.mybatisplus.extension.service.IService;
import com.fh.product.entity.vo.PmsProductVO;

/**
 * <p>
 * 商品信息 服务类
 * </p>
 *
 * @author liqiang
 * @since 2020-12-13
 */
public interface IPmsProductService extends IService<PmsProduct> {

    void saveOrUpdateProduct(PmsProductVO pmsProductVO);

    PmsProductVO queryProductById(Integer productId);
}
