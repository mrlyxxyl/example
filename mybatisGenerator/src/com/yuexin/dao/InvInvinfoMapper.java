package com.yuexin.dao;

import com.yuexin.model.InvInvinfo;

public interface InvInvinfoMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table INV_INVINFO
     *
     * @mbggenerated Sun Apr 13 16:37:09 CST 2014
     */
    int deleteByPrimaryKey(String pkid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table INV_INVINFO
     *
     * @mbggenerated Sun Apr 13 16:37:09 CST 2014
     */
    int insert(InvInvinfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table INV_INVINFO
     *
     * @mbggenerated Sun Apr 13 16:37:09 CST 2014
     */
    int insertSelective(InvInvinfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table INV_INVINFO
     *
     * @mbggenerated Sun Apr 13 16:37:09 CST 2014
     */
    InvInvinfo selectByPrimaryKey(String pkid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table INV_INVINFO
     *
     * @mbggenerated Sun Apr 13 16:37:09 CST 2014
     */
    int updateByPrimaryKeySelective(InvInvinfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table INV_INVINFO
     *
     * @mbggenerated Sun Apr 13 16:37:09 CST 2014
     */
    int updateByPrimaryKey(InvInvinfo record);
}