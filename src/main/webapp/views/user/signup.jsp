<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="../../layouts/header.jsp" %>

<script type="text/javascript">

    $(document).ready(() => {


    });

    const signup = () => {
        const id = $("#id").val();
        const password = $("#password").val();
        const nickname = $("#nickname").val();

        $.ajax({
            url: "/api/user/signup",
            type: "POST",
            data: {
                id,
                password,
                nickname,
            },
            success: function(response) {
                alert("계정 생성이 완료되었습니다.");
                window.location.href="/user/login";
            },
            error: function(response) {
                alert("계정 생성에 실패하였습니다.");
            }
        });
    }
</script>

<div>
    <input type="text" id="id" placeholder="아이디" />
    <input type="password" id="password" placeholder="패스워드" />
    <input type="text" id="nickname" placeholder="닉네임" />
    <button type="button" onclick="signup()">회원가입</button>
</div>


<%@ include file="../../layouts/footer.jsp" %>