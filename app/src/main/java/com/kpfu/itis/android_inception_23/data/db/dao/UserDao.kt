package com.kpfu.itis.android_inception_23.data.db.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.kpfu.itis.android_inception_23.data.db.entity.UserEntity
import com.kpfu.itis.android_inception_23.data.db.entity.tuple.UserAddressTuple
import com.kpfu.itis.android_inception_23.data.db.entity.tuple.UserIdTuple

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addUser(userData: UserEntity)

    @Query("SELECT * FROM user")
    fun getAllUsers(): List<UserEntity>?

    @Query("SELECT * FROM user WHERE id = :userId")
    fun getUserInfoById(userId: String): UserEntity?

    @Update(entity = UserEntity::class)
    fun updateUserAddress(data: UserAddressTuple)

    @Query("UPDATE user SET email = :emailAddress WHERE id = :id")
    fun updateUserAddressQuery(id: String, emailAddress: String)

    @Delete(entity = UserEntity::class)
    fun deleteUserById(id: UserIdTuple)

    @Query("DELETE FROM user WHERE id = :id")
    fun deleteUserByIdQuery(id: String)
}