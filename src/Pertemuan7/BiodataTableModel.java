/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Pertemuan7;

// ini adalah baris import yang menyertakan berbagai kelas yang dibutuhkan
import Pertemuan7.*;
import javax.swing.table.*;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Faqih firdaus k.p
 */

// baris ini adalah class BiodataTableModel yang memiliki turunan dari AbstractTableModel
public class BiodataTableModel extends AbstractTableModel {

    // baris ini adalah sebuah array yang berisi nama, no telepon, jenis kelamin dan Alamat dalam tabel output
    private String[] columnNames = { "Nama", "No Telepon", "Jenis Kelamin", "Alamat" };
    // baris ini memiliki variabel data untuk menyimpan data yang akan ditampikan di tabel output
    private ArrayList<ArrayList<String>> data = new ArrayList<ArrayList<String>>();

    // baris ini untuk mengembalikan jumlah kolom dalam tabel yaitu panjang dari array
    public int getColumnCount() {
        return columnNames.length;
    }
    
    // baris ini untuk mengembalikan jumlah baris dalam tabel yang sesuai dengan jumlah elemen dalam arrayList "data"
    public int getRowCount() {
        return data.size();
    }

    // baris ini untuk mengambil nama kolom
    public String getColumnName(int col) {
        return columnNames[col];
    }
    
    // baris ini untuk mendapatkan nilai dalam tabel berdasarkan indeks baris dan kolom
    public Object getValueAt(int row, int col) {
        List<String> rowItem = data.get(row);
        return rowItem.get(col);
    }
    
    // baris ini untuk mengembalikan false yang berarti sel dalam tabel output tidak bisa di ubah
    public boolean isCellEditable(int row, int col) {
        return false;
    }
    
    public ArrayList<ArrayList<String>> getData() {
        return data;
    }

    // baris ini untuk menambahkan baris baru ke tabel
    public void add(ArrayList<String> value) {
        data.add(value);
        fireTableRowsInserted(data.size() - 1, data.size() - 1);
    }
    
     @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        ArrayList<String> row = data.get(rowIndex);
        row.set(columnIndex, (String) aValue);
        fireTableCellUpdated(rowIndex, columnIndex);
    }
    
      public void update(ArrayList<String> newValue, int row) {
        data.set(row, newValue);
        fireTableRowsUpdated(row, row);
    }
      
       public void remove(int row) {
        data.remove(row);
        fireTableRowsDeleted(row, row);
    }
    

}
