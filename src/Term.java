import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="Index")
public class Term {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id") 
	int id;
	/*test*/
	@Column(name = "term") 
	String name;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id") 
	public int getId() {
		return id;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id") 
	public void setId(int id) {
		this.id = id;
	}
	@Column(name = "term") 
	public String getName() {
		return name;
	}
	@Column(name = "term") 
	public void setName(String name) {
		this.name = name;
	}

	public Term(int id, String name) {
		this.id = id;
		this.name = name;
	}
	public Term() {
		
	}

}
