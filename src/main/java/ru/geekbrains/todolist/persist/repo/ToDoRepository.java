package ru.geekbrains.todolist.persist.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.geekbrains.todolist.persist.entity.ToDo;
import ru.geekbrains.todolist.repr.ToDoRepr;

import java.util.List;

@Repository
public interface ToDoRepository extends CrudRepository<ToDo, Long> {
    // Описание запроса к методу
//    @Query("select new ru.geekbrains.todolist.repr.ToDoRepr(t) from ToDo t " +
//            "where t.user.id = :userId")
    @Query("select new ru.geekbrains.todolist.repr.ToDoRepr(t.id, t.description, t.user.username, t.targetDate) " +
            "from ToDo t " +
            "where t.user.id = :userId")
    List<ToDoRepr> findToDosByUserId(@Param("userId") Long userId);
}