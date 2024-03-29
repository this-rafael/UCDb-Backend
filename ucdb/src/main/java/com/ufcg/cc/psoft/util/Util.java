package com.ufcg.cc.psoft.util;

import com.ufcg.cc.psoft.ucdb.dao.SubjectDAO;
import com.ufcg.cc.psoft.ucdb.dao.StudentDAO;
import com.ufcg.cc.psoft.ucdb.model.Subject;
import com.ufcg.cc.psoft.ucdb.model.Student;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.json.simple.JSONObject;

import javax.xml.bind.DatatypeConverter;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

public class Util {

    public Student getStudent(String token, StudentDAO studentDAO) {
//        String userEmail = (String) request.get("user_token"); isso é para testes
        // TODO: GERA EXCEOTION
        // TODO: ERA BOM VERICAR SE O TOKEN EXISTE, SE ELE EH VALIDO
        String userEmail = this.decodeJWT(token, "HAPPY_TOMATO").getSubject();

        // TODO: SE FOR NECESSARIO DEVERIA TER UMA VERIFCACAO PARA VER SE USER != NULL
        final Student student = studentDAO.studentFindByEmail(userEmail);

        return student;
    }

    public Subject getSubject(JSONObject request, SubjectDAO subjectDAO) {
        String subjectId = (String) request.get("subject");
        final long id = Long.parseLong(subjectId);
        return subjectDAO.findById(id);
    }

    public String reconvertValidUrlToOriginalString(String url) {
        try {
            return java.net.URLDecoder.decode(url, StandardCharsets.UTF_8.name());
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return "";
    }

    public Claims decodeJWT(String jwt, String secretKey) {
        Claims claims = Jwts.parser()
                .setSigningKey(DatatypeConverter.parseBase64Binary(secretKey))
                .parseClaimsJws(jwt).getBody();
        return claims;
    }


    public Student getSuperUserComment(JSONObject request, String user, StudentDAO studentDAO) {
        String userEmail = this.decodeJWT((String) request.get(user), "HAPPY_TOMATO").getSubject();

        return studentDAO.studentFindByEmail(userEmail);/*TODO AJUSTAR ISSO */
    }
}
