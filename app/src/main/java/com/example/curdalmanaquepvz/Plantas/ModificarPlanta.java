package com.example.curdalmanaquepvz.Plantas;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.curdalmanaquepvz.Conexion.DbHelper;
import com.example.curdalmanaquepvz.DAO_JDBC.PlantaDAO_JDBC;
import com.example.curdalmanaquepvz.Dominio.PlantaDTO;
import com.example.curdalmanaquepvz.R;

public class ModificarPlanta extends AppCompatActivity {

    EditText et_NombrePlanta, et_TipoPlanta, et_FaseDesbloqueoPlanta, et_CosteSolesPlanta;
    Button btnModificarPlanta;
    Button btnEliminarPlanta;
    PlantaDTO plantita = new PlantaDTO();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modificar_planta);
        Bundle b = getIntent().getExtras();
        if (b!=null){

            plantita.setId_planta(b.getInt("id"));
            plantita.setNombre_planta(b.getString("nombre"));
            plantita.setTipo_planta(b.getString("tipo"));
            plantita.setFase_desbloqueoPlanta(b.getString("fase"));
            plantita.setCoste_SolesPlanta(b.getInt("coste"));
        }

        et_NombrePlanta = (EditText) findViewById(R.id.et_NombrePlanta);
        et_TipoPlanta = (EditText) findViewById(R.id.et_TipoPlanta);
        et_FaseDesbloqueoPlanta = (EditText) findViewById(R.id.et_FaseDesbloqueoPlanta);
        et_CosteSolesPlanta = (EditText) findViewById(R.id.et_CosteSolesPlanta);

        et_NombrePlanta.setText(plantita.getNombre_planta());
        et_TipoPlanta.setText(plantita.getTipo_planta());
        et_FaseDesbloqueoPlanta.setText(plantita.getFase_desbloqueoPlanta());
        et_CosteSolesPlanta.setText(String.valueOf(plantita.getCoste_SolesPlanta()));




        btnModificarPlanta = (Button) findViewById(R.id.btnModificarPlanta);
        btnEliminarPlanta = (Button) findViewById(R.id.btnEliminarPlanta);

        btnModificarPlanta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PlantaDTO plantitaModificar = new PlantaDTO();
                PlantaDAO_JDBC metodoUpdatePl = new PlantaDAO_JDBC();

                plantitaModificar.setId_planta(plantita.getId_planta());
                plantitaModificar.setNombre_planta(et_NombrePlanta.getText().toString());
                plantitaModificar.setTipo_planta(et_TipoPlanta.getText().toString());
                plantitaModificar.setFase_desbloqueoPlanta(et_FaseDesbloqueoPlanta.getText().toString());
                plantitaModificar.setCoste_SolesPlanta(Integer.parseInt(et_CosteSolesPlanta.getText().toString()));
                metodoUpdatePl.UpdatePl(plantitaModificar, ModificarPlanta.this);
                onBackPressed();
                Toast.makeText(ModificarPlanta.this, "Planta modificada", Toast.LENGTH_SHORT).show();
            }
        });

        btnEliminarPlanta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PlantaDAO_JDBC metodoDeletePl = new PlantaDAO_JDBC();
                metodoDeletePl.DeletePl(plantita, ModificarPlanta.this);
                onBackPressed();
                Toast.makeText(ModificarPlanta.this, "Planta eliminada", Toast.LENGTH_SHORT).show();
            }
        });

    }

}