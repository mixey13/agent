package mixey.agent.web;

import mixey.agent.model.Product;
import mixey.agent.repository.InMemoryProductRepository;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class productServlet extends HttpServlet {
    private InMemoryProductRepository repository = new InMemoryProductRepository();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> list = repository.getAll().stream().collect(Collectors.toList());
        request.setAttribute("productList", list);
        request.getRequestDispatcher("/productList.jsp").forward(request, response);
    }
}
