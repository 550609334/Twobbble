package com.twobbble.biz.api

import com.twobbble.entity.NullResponse
import com.twobbble.entity.Shot
import com.twobbble.entity.Token
import com.twobbble.entity.User
import com.twobbble.tools.NetObserver
import org.jetbrains.annotations.NotNull

/**
 * Created by liuzipeng on 2017/3/5.
 */
interface IUserBiz {
    /**
     * 登录获取token
     */
    fun getToken(oauthCode: String, netObserver: NetObserver<Token>)

    /**
     * 获取登录的用户信息
     *
     * @param access_token 用户登录后获得的token
     */
    fun getMyInfo(@NotNull access_token: String, netObserver: NetObserver<User>)

    /**
     * 获取一个用户的shot
     * @param user 用户类型   user是自己   users是其它用户
     * @param id 用户id   如果是自己的  给null
     * @param access_token
     * @param page 页码
     */
    fun getUserShot(@NotNull user: String,
                    id: String?,
                    @NotNull access_token: String,
                    page: Int?,
                    netObserver: NetObserver<MutableList<Shot>>)

    /**
     * 检查是否已关注这个用户
     * @param access_token
     * @param id  要检查的用户的id
     */
    fun checkIfFollowingUser(@NotNull id: Long,
                             @NotNull access_token: String, netObserver: NetObserver<NullResponse>)

    /**
     * 关注一个用户
     * @param access_token
     * @param id  要关注的用户的id
     */
    fun followUser(@NotNull id: Long,
                   @NotNull access_token: String, netObserver: NetObserver<NullResponse>)

    /**
     * 取消关注一个用户
     * @param access_token
     * @param id  要取关的用户的id
     */
    fun unFollowUser(@NotNull id: Long,
                     @NotNull access_token: String, netObserver: NetObserver<NullResponse>)
}