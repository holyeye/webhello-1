package myboard.repository;

import myboard.entity.Board;


import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * User: HolyEyE
 * Date: 13. 2. 27. Time: 오후 5:22
 */
public class BoardDatabaseRepository implements BoardRepository {


    //private static int keyStore = 0;

    private static BoardDatabaseRepository instance = new BoardDatabaseRepository();
    private String BoardUrl = "jdbc:postgresql://localhost:5432/webboard";
    private String BoardUser = "webconn";
    private String BoardPwd = "webconn";
    private String BoardTbl = "webboard";

    private List<Board> boards = new ArrayList<Board>();

    public static BoardDatabaseRepository getInstance() {
        return instance;
    }

    private BoardDatabaseRepository() {
    }

    @Override
    public List<Board> getBoards() {
        Connection conn = null;
        ResultSet result = null;
        PreparedStatement pstmt = null;
        List<Board> boards = new ArrayList<Board>();

        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(BoardUrl, BoardUser, BoardPwd);
            pstmt = conn.prepareStatement("SELECT id,title,writer,pw,content FROM "+BoardTbl);
            result = pstmt.executeQuery();


            while(result.next()){
                Board board = new Board();
                board.setId(result.getInt("id"));
                board.setTitle(result.getString("title"));
                board.setWriter(result.getString("writer"));
                board.setPw(result.getString("pw"));
                board.setContent(result.getString("content"));
                boards.add(board);
            }

        } catch (SQLException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (ClassNotFoundException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                }
            }
        }

        return boards;
    }

    @Override
    public void addBoard(Board board) {

        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(BoardUrl, BoardUser, BoardPwd);
            pstmt = conn.prepareStatement("INSERT INTO "+BoardTbl+" (title,writer,pw,content) values (?,?,?,?)");
            pstmt.setString(1,board.getTitle());
            pstmt.setString(2,board.getWriter());
            pstmt.setString(3,board.getPw());
            pstmt.setString(4,board.getContent());
            pstmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (ClassNotFoundException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                }
            }
        }
    }

    @Override
    public Board searchBoard(int key) {
//        for (Board board : boards) {
//            if (board.getId() == key) {
//                return board;
//            }
//        }
//        return null;
        Connection conn = null;
        ResultSet result = null;
        PreparedStatement pstmt = null;
        Board board = new Board();

        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(BoardUrl, BoardUser, BoardPwd);
            pstmt = conn.prepareStatement("SELECT id,title,writer,pw,content FROM "+BoardTbl+" WHERE id = ?");
            pstmt.setInt(1, key);
            result = pstmt.executeQuery();

            while(result.next()){
                board.setId(result.getInt("id"));
                board.setTitle(result.getString("title"));
                board.setWriter(result.getString("writer"));
                board.setPw(result.getString("pw"));
                board.setContent(result.getString("content"));
            }
        } catch (SQLException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (ClassNotFoundException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                }
            }
        }

        return board;
    }

    @Override
    public void delBoard(int key) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(BoardUrl, BoardUser, BoardPwd);
            pstmt = conn.prepareStatement("DELETE FROM "+BoardTbl+" WHERE id = ?");
            pstmt.setInt(1, key);
            pstmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (ClassNotFoundException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                }
            }
        }
    }

    @Override
    public void updateBoard(Board board) {

        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(BoardUrl, BoardUser, BoardPwd);
            pstmt = conn.prepareStatement("UPDATE "+BoardTbl+" set title=? ,writer=?,pw=?,content=? WHERE id=?");
            pstmt.setString(1,board.getTitle());
            pstmt.setString(2,board.getWriter());
            pstmt.setString(3,board.getPw());
            pstmt.setString(4,board.getContent());
            pstmt.setInt(5,board.getId());
            pstmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (ClassNotFoundException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                }
            }
        }
    }

    private synchronized int generateId() {
        //return keyStore++;
        return 0;
    }

}
