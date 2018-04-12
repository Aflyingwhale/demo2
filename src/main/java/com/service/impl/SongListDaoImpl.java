package com.service.impl;



import com.controller.LoginController;
import com.service.interfaces.SongListDao;
import org.junit.Test;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/*jdbc操作songlist_userid_tablename表*/
@Service
public class SongListDaoImpl implements SongListDao {
    private org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(LoginController.class);

    static String driver = "com.mysql.jdbc.Driver";
    static String url = "jdbc:mysql://localhost:3306/mcdb?useUnicode=true&characterEncoding=UTF-8";
    static String user = "root";
    static String password = "root";

    Connection connection = null;
    Statement stat = null;
    @Override
    public boolean createSongList(String userId,String tablename){
        boolean createflg=true;
        if (tablename==null)
            tablename="我喜爱的";
        try {
            Class.forName(driver);
            //jdbc 对事务的提交是 自动
            connection =  DriverManager.getConnection(url, user, password);

            //设置手动提交 默认自动 -true  手动 - false;
            connection.setAutoCommit(false);

            stat = connection.createStatement();

            String sql ="Create table songlist_"+ userId+"_"+tablename+"(" +
                    "Music_id int not null,"+
                    "Views int ," +
                    "Love int(1) not null," +
                    "Foreign key (music_id) references musics(id)" +
                    ")engine=innodb default charset=utf8 auto_increment=1";
            logger.info("sql:"+sql);
            boolean flag=stat.execute(sql);
            logger.info("create table songlist_"+userId+"_"+tablename+"  success");
        } catch (Exception e) {
            e.printStackTrace();
            logger.info("create table songlist_"+userId+"_"+tablename+"  fail");
        }  finally {
            try {
                //为了避免NullPoint
                //关闭连接对象
                if(connection!=null){
                    connection.close();
                }
                //关闭会话
                if(stat!=null){
                    stat.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return createflg;
    }

    @Test
    public void test(){
        createSongList("3",null);
    }
}


