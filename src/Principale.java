import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.ismo.dao.DAOProduit;
import com.ismo.dao.IDao;
import com.ismo.model.Produit;

public class Principale {
	
	public static void displayProds(List<Produit> p) {
		
		p.stream().forEach(item -> System.out.println(item));
	}

	public static void main(String[] args) throws FileNotFoundException, ClassNotFoundException, IOException, SQLException {
		
		IDao<Produit> dao = new DAOProduit();
		
		List<Produit> prds = dao.getAll();
		
		displayProds(prds);
		
		System.out.println("--------------------------------------------------");
		List<Produit> qst2 = prds.stream()
				.filter(item -> item.getNom().startsWith("d") && item.getPrix_achat() > 20)
				.collect(Collectors.toList());
		
		displayProds(qst2);
		System.out.println("--------------------------------------------------");
		List<Produit> qst3 = prds.stream()
				.map(item -> {
					item.setPrix_achat(item.getPrix_achat()*1.2);
					return item;
				})
				.collect(Collectors.toList());
		
		displayProds(qst3);

	}

}
