package inmobiliaria;

public class usuario {
	String usuario="";
	String contrasena="";

public int ProbarUsuario()
	{
	usuario=login.txtIusuario.getText();
	contrasena=login.txtcontrasena.getText();
	if(usuario.equals ("root")&& contrasena.equals (""))
		{
			return 1;
		}
		else
		{
			return 0;
		}
	}
}
