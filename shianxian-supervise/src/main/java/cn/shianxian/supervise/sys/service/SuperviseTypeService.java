package cn.shianxian.supervise.sys.service;

import cn.shianxian.supervise.common.pojo.Result;
import cn.shianxian.supervise.sys.dto.DataAuthorityDTO;
import cn.shianxian.supervise.sys.pojo.SuperviseType;
import org.springframework.http.ResponseEntity;

public interface SuperviseTypeService {


    /**
     * 保存、修改监管类型控制器
     * @param superviseType
     * @return
     */
    Result saveOrUpdateSuperviseType(SuperviseType superviseType);


    /**
     * 删除监管类型
     * @param ids
     * @return
     */
    ResponseEntity<Result> deleteSuperviseTypeById(String ids);


    /**
     * 查询监管类型
     * @param superviseType
     * @return
     */
    Result selectSuperviseType(SuperviseType superviseType);


    /**
     * 修改监管类型排序
     * @param id
     * @param type
     * @return
     */
    Result updateSuperviseTypeBySort(String id, int type);


    /**
     * 查询监管类型（树形）
     * @param superviseType
     * @return
     */
    Result selectSuperviseTypeTree(SuperviseType superviseType);


    /**
     * 根据id查询监管类型
     * @param id
     * @return
     */
    Result selectSuperviseTypeById(String id);


    /**
     * 批量赋予监管类型权限
     * @param dataAuthorityDTO
     * @return
     */
    Result batchUpdateSuperviseTypeAuthority(DataAuthorityDTO dataAuthorityDTO);


    /**
     * 批量清空监管类型权限
     * @param ids
     * @return
     */
    Result batchDeleteSuperviseTypeAuthority(String[] ids);


    /**
     * 根据监管类型id查询监管类型权限
     * @param id
     * @return
     */
    Result selectSuperviseTypeAuthorityById(String id);


    /**
     * 修改监管类型权限
     * @param superviseType
     * @return
     */
    Result updateSuperviseTypeAuthority(SuperviseType superviseType);


    /**
     * 查询所有监管类型（树形）
     * @param superviseType
     * @return
     */
    Result selectSuperviseTypeAllTree(SuperviseType superviseType);
}
