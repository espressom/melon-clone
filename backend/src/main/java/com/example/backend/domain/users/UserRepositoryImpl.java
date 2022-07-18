package com.example.backend.domain.users;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import static com.example.backend.domain.users.QUser.user;

@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepositoryCustom{

    private final JPAQueryFactory queryFactory;

//    @Override
//    public boolean isLoggedInUser(User identifyingUser) {
//        return Boolean.TRUE.equals(queryFactory
//                .from(user)
//                .select(user.isLoggedIn)
//                .where(user.id.eq(identifyingUser.getId()))
//                .fetchOne());
//    }
}
