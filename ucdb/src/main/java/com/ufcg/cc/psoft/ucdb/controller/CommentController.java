package com.ufcg.cc.psoft.ucdb.controller;

import com.ufcg.cc.psoft.ucdb.service.CommentService;
import org.json.simple.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"v1/comment"})
public class CommentController {
    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    /**
     * Sintaxe:
     * { "user":"email_user", "subject" : "subject_id", "comment" : "comentario"}
     */
    @PostMapping(value = "/create/{id}")
    public void commentSubject(@RequestHeader ("Authorization") String token,  @PathVariable long id, @RequestBody JSONObject request) {
        this.commentService.commentSubject(token.substring(7), id, request);
    }

    /**
     * Sintaxe:
     * {
     * "superCommentUserEmail" : "email_do_usuario_do_comentario_pai"
     * "superCommentSubjectID" : "id_da_disciplina_do_comentario_pai"
     * "subCommentUserEmail" : "email_do_usuario_do_comentario_filho"
     * "comment": "a resposta do comentario"
     * }
     */
    @PostMapping(value = "/reply/{idSubject}/{idComment}")
    public void addSubcommentToSubject(@RequestHeader ("Authorization") String token, @PathVariable long  idSubject ,
                                       @PathVariable long idComment, @RequestBody JSONObject request) {
        this.commentService.addSubcommentToSubject(token.substring(7), idComment, idSubject,request);
    }

    @DeleteMapping(value = "/{id}") /*o id eh uma string composta no formato subjectID_UserEmail */
    public ResponseEntity delete(@RequestHeader ("Authorization") String token, @PathVariable long id) {
        this.commentService.deleteComment(token.substring(7), id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping(value = "/subject_comments/{id}")
    public ResponseEntity<List> getComments(@PathVariable long id) {
        List comments = this.commentService.getComments(id);
        return new ResponseEntity<>(comments, HttpStatus.OK);
    }
}
