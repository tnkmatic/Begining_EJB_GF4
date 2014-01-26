/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package begining.gf4.web.common;

/**
 *
 * @author Eiichi Tanaka
 */
public class ConstantValueQuery {
    public final static String PARAM_BOOK503_ISBN = "isbn";
    
    public final static String NAMED_FIND_ALL_BOOKS503 = "findAllBooks503";
    public final static String QUERY_FIND_ALL_BOOKS503 = 
            "SELECT b FROM Book503 b";
    
    
    public final static String NAMED_FIND_BOOK503_BY_ISBN = "findBook503ByIsbn";
    public final static String QUERY_FIND_BOOK503_BY_ISBN = 
            "SELECT b FROM Book503 b WHERE b.isbn = :" + PARAM_BOOK503_ISBN;
}
