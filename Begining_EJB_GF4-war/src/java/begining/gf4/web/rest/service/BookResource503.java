/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package begining.gf4.web.rest.service;

import begining.gf4.web.common.ConstantValueQuery;
import begining.gf4.web.jpa.entity.Book503;
import java.net.URI;
import java.util.List;
import java.util.logging.Level;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

/**
 *
 * @author Eiichi Tanaka
 */
@Path("/books")
@Stateless
@LocalBean
public class BookResource503 {
    @Context
    private UriInfo uriInfo;
    
    @PersistenceContext(unitName = "Begining_EJB_GF4-warPU")
    private EntityManager em;
    
    private final static java.util.logging.Logger logger = 
            java.util.logging.Logger.getLogger(BookResource503.class.getName());
    
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public List<Book503> getAllBooks() {
        logger.log(Level.INFO
                ,"START getAllBooks"
                ,new String[] {
                });
        
        Query query = em.createNamedQuery(
                ConstantValueQuery.NAMED_FIND_ALL_BOOKS503);
        List<Book503> books = query.getResultList();
        return books;
    }
    
    @GET
    @Path("{" + ConstantValueQuery.PARAM_BOOK503_ISBN + "}")
    @Produces({MediaType.APPLICATION_JSON})
    public Book503 getBook(
            @PathParam(ConstantValueQuery.PARAM_BOOK503_ISBN) String isbn) {
        logger.log(Level.INFO
                ,"START getBook"
                ,new String[] {
                });
        
        Query query = em.createNamedQuery(
                ConstantValueQuery.NAMED_FIND_BOOK503_BY_ISBN);
        query.setParameter(ConstantValueQuery.PARAM_BOOK503_ISBN, isbn);
        
        Book503 book = (Book503) query.getSingleResult();
        
        logger.log(Level.INFO
                ,"Result Book503 : id={0}, isbn={1}, title={2}"
                ,new String[] {
                    book.getId().toString(),
                    book.getIsbn(),
                    book.getTitle()
                });
        
        return book;
    }
    
    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    public Response createNewBook(Book503 book) {
        logger.log(Level.INFO
        ,"START createNewBook : {0}"
        ,new String[] {
            book.getTitle()
        });

        Response response = null;

        //新規作成対象の永続化
        em.persist(book);

        URI bookUri = uriInfo.getAbsolutePathBuilder().path(
                book.getId().toString()).build();        
        response = Response.created(bookUri).build();
        
        logger.log(Level.INFO
                ,response.toString()
                ,new String[] {                    
                });
        
        return response;
    }
    
    @POST
    @Consumes({MediaType.APPLICATION_FORM_URLENCODED})
    public Response createNewBookByForm(
            @FormParam(ConstantValueQuery.PARAM_BOOK503_ISBN) String isbn
           ,@FormParam(ConstantValueQuery.PARAM_BOOK503_TITLE) String title) {
        logger.log(Level.INFO
        ,"START createNewBookByForm : isbn={0}, title={1}"
        ,new String[] {
            isbn
            ,title
        });
        
        Response response = null;
        
        Book503 book = new Book503();
        book.setIsbn(isbn);
        book.setTitle(title);
        
        //新規作成対象の永続化
        em.persist(book);
        
        URI bookUri = uriInfo.getAbsolutePathBuilder().path(
                book.getId().toString()).build();
        response = Response.created(bookUri).build();
        
        logger.log(Level.INFO
                ,response.toString()
                ,new String[] {                    
                });

        return response;
    }
    
    @PUT
    @Path("{" + ConstantValueQuery.PARAM_BOOK503_ISBN + "}")
    @Consumes({MediaType.APPLICATION_JSON})
    public void updateBook(
            @PathParam(ConstantValueQuery.PARAM_BOOK503_ISBN) String isbn
            ,Book503 book) {
        //開始ログ
        logger.log(Level.INFO
        ,"START updateBook : isbn={0}, title={1}"
        ,new String[] {
            isbn
            ,book.getTitle()
        });
        
        //更新対象の取得
        Query query = em.createNamedQuery(
                ConstantValueQuery.NAMED_FIND_BOOK503_BY_ISBN);
        query.setParameter(ConstantValueQuery.PARAM_BOOK503_ISBN, isbn);        
        Book503 nowBook = (Book503) query.getSingleResult();
        
        logger.log(Level.INFO
                   ,"Now Title={0}, Update Title={1}"
                   ,new String[] {
                       nowBook.getTitle()
                       ,book.getTitle()
                   });
        
        //本の更新
        nowBook.setTitle(book.getTitle());
        em.persist(nowBook);
    }
    
    @DELETE
    @Path("{" + ConstantValueQuery.PARAM_BOOK503_ISBN + "}")
    public void deleteBook(
            @PathParam(ConstantValueQuery.PARAM_BOOK503_ISBN) String isbn) {
        //開始ログ
        logger.log(Level.INFO
        ,"START deleteBook : isbn={0}"
        ,new String[] {isbn});
        
        //削除対象の取得
        Query query = em.createNamedQuery(
                ConstantValueQuery.NAMED_FIND_BOOK503_BY_ISBN);
        query.setParameter(ConstantValueQuery.PARAM_BOOK503_ISBN, isbn);
        final Book503 book = (Book503) query.getSingleResult();

        //本の削除
        em.remove(book);
    }
}
