import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import com.ismo.dao.DAOProduit;
import com.ismo.dao.IDao;
import com.ismo.model.Produit;

public class Principale {

	public static void main(String[] args) throws FileNotFoundException, ClassNotFoundException, IOException, SQLException {
		
		IDao<Produit> dao = new DAOProduit();
		
		dao.delete(6);

	}

}
