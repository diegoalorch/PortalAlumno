package pe.edu.upeu.portal.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import pe.edu.upeu.portal.Dao.AlumnoDao;
import pe.edu.upeu.portal.Dao.EscuelaDao;
import pe.edu.upeu.portal.DaoImp.AlumnoDaoImp;
import pe.edu.upeu.portal.DaoImp.EscuelaDaoImp;
import pe.edu.upeu.portal.entity.Alumno;
import pe.edu.upeu.portal.entity.Escuela;

/**
 * Servlet implementation class AlumnoController
 */
@WebServlet("/ac")
public class AlumnoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Gson gson = new Gson();
	AlumnoDao alumnoDao = new AlumnoDaoImp();
	EscuelaDao escuelaDao = new EscuelaDaoImp();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AlumnoController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		int op = Integer.parseInt(request.getParameter("op"));
		switch (op) {
		case 1:
			Alumno alumno = alumnoDao.findstudent(Integer.parseInt(request.getParameter("idalumno")));
			out.println(gson.toJson(alumno));
			break;
		case 2:
			List<Alumno> alumnos = alumnoDao.readstudent();
			out.println(gson.toJson(alumnos));
			break;
		case 3:
			List<Escuela> escuelas = escuelaDao.listarescuelas();
			out.println(gson.toJson(escuelas));
			break;
		case 4:
			Alumno alumno4 = new Alumno(0, Integer.parseInt(request.getParameter("idescuela")), request.getParameter("apellidonombres"), request.getParameter("correo"), request.getParameter("telefono"));
			out.println(gson.toJson(alumnoDao.createstudent(alumno4)));
			break;
		default:
			break;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		PrintWriter out = response.getWriter();
		int op = Integer.parseInt(request.getParameter("op"));
		switch (op) {
		case 2:
			Alumno alumno2 = new Alumno(0, Integer.parseInt(request.getParameter("idescuela")), request.getParameter("apellidonombres"), request.getParameter("correo"), request.getParameter("telefono"));
			out.println(gson.toJson(alumnoDao.updatestudent(alumno2)));
			break;
		case 3:
			int alumno3 = alumnoDao.deletestudent(Integer.parseInt(request.getParameter("idalumno")));
			out.println(gson.toJson(alumno3));
			break;
		
		default:
			break;
		}
	}

}
