<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="../../layouts/header.jsp" %>

<script type="text/javascript">

    $(document).ready(() => {


    });

    const login = () => {
        const id = $("#id").val();
        const password = $("#password").val();

        $.ajax({
            url: "/api/user/login",
            type: "POST",
            data: {
                id,
                password,
            },
            success: function(response) {
                alert("로그인 성공");
            },
            error: function(response) {
                alert("로그인 실패");
            }
        });
    }
</script>

<div>
    <input type="text" id="id" placeholder="아이디" />
    <input type="password" id="password" placeholder="패스워드" />
    <button type="button" onclick="login()">로그인</button>
    <a href="/user/signup"><button type="button">회원가입</button></a>
</div>


<%@ include file="../../layouts/footer.jsp" %>