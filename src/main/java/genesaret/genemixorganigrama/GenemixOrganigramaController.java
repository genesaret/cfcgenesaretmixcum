/**
 * 
 */
package genesaret.genemixorganigrama;

import java.io.Serializable;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;

import org.primefaces.extensions.component.gchart.model.GChartModel;
import org.primefaces.extensions.component.gchart.model.GChartModelBuilder;
import org.primefaces.extensions.component.gchart.model.GChartType;
import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;


/**
 * @author scooter pc
 *
 */
@ManagedBean  
@RequestScoped  
public class GenemixOrganigramaController implements Serializable { 
	  
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private GChartModel standardModel = null;  
    private GChartModel treeModel = null;  
  
    public GChartModel getStandardModel(){  
        return standardModel;  
    }  
  
    public GChartModel getTreeModel() {  
        return treeModel;  
    }  
  
    @PostConstruct  
    public void generateModel() {  
        standardModel = new GChartModelBuilder().setChartType(GChartType.ORGANIZATIONAL)  
                .addColumns("Name","Manager")  
                .addRow("Mike", "")  
                .addRow("Alice", "Mike")  
                .addRow("Jim", "Mike")  
                .addRow("Bob", "Alice")  
                .addOption("size", "large")  
                .build();  
  
        TreeNode mike = new DefaultTreeNode("Mike");  
        TreeNode alice = new DefaultTreeNode("Alice",mike);  
        TreeNode jim = new DefaultTreeNode("Jim",mike);  
        TreeNode bob = new DefaultTreeNode("Bob",alice);  
  
        treeModel = new GChartModelBuilder().setChartType(GChartType.ORGANIZATIONAL)  
                .addColumns("Name","Manager")  
                .importTreeNode(mike)  
                .addOption("size", "large")  
                .build();  
    }  
  

}
