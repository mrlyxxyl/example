package action;

import com.yuexin.bean.People;
import org.primefaces.component.datatable.DataTable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@ManagedBean
@ViewScoped
public class BtnAction implements Serializable {
    private boolean flag;
    private Thread thread;
    private List<People> list;
    private DataTable dataTable;


    public void btnOne() {
        this.flag = true;
        MyRunnable myRunnable = new MyRunnable("btnOne");
        thread = new Thread(myRunnable);
        thread.start();
    }

    public void btnTwo() {
        dataTable = new DataTable();
        list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(new People("name" + i, i));
        }
        dataTable.setValue(list);
    }

    public void addMessage() {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ddd", "ddd"));
    }

    class MyRunnable implements Runnable {
        private String msg;

        public MyRunnable(String msg) {
            this.msg = msg;
        }

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (flag) {
                    System.out.println(msg + "------" + i);
                }
            }
        }
    }

    public List<People> getList() {
        return list;
    }

    public void setList(List<People> list) {
        this.list = list;
    }

    public DataTable getDataTable() {
        return dataTable;
    }

    public void setDataTable(DataTable dataTable) {
        this.dataTable = dataTable;
    }
}
