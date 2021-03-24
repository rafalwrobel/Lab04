package pollub.ism.lab04;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public int gracz = 0;
    public int ruch = 0;
    public int wygrana = 0;
    public int jakiPrzycisk1 ;
    public int jakiPrzycisk2 ;
    public char znak;
    public char [][]tabelaZnakow = new char[3][3];

    public Button []tablicaPrzyciskow = new Button[9];




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void czyscPlansze()
    {
        for(int i=0; i<ruch; i++)
        {
            tablicaPrzyciskow[i].setText("");
            tablicaPrzyciskow[i].setClickable(true);
        }
        
        for(int i=0; i<3; i++)
        {
            for(int j=0; j<3; j++)
                tabelaZnakow[i][j] = '-';
        }
            
        ruch = 0;
        wygrana = 0;
        gracz = 0;
    }

    public void czyWygrana()
    {
        char znakPomocniczy = 'X';

        for(int i=1; i<=2; i++)
        {

            if(tabelaZnakow[0][0] == znakPomocniczy && tabelaZnakow[0][1] == znakPomocniczy && tabelaZnakow[0][2] == znakPomocniczy)
            {wygrana = i;}

            if(tabelaZnakow[1][0] == znakPomocniczy && tabelaZnakow[1][1] == znakPomocniczy && tabelaZnakow[1][2] == znakPomocniczy)
            {wygrana = i;}

            if(tabelaZnakow[2][0] == znakPomocniczy && tabelaZnakow[2][1] == znakPomocniczy && tabelaZnakow[2][2] == znakPomocniczy)
            {wygrana = i;}

            if(tabelaZnakow[0][0] == znakPomocniczy && tabelaZnakow[1][0] == znakPomocniczy && tabelaZnakow[2][0] == znakPomocniczy)
            {wygrana = i;}

            if(tabelaZnakow[0][1] == znakPomocniczy && tabelaZnakow[1][1] == znakPomocniczy && tabelaZnakow[2][1] == znakPomocniczy)
            {wygrana = i;}

            if(tabelaZnakow[0][2] == znakPomocniczy && tabelaZnakow[1][2] == znakPomocniczy && tabelaZnakow[2][2] == znakPomocniczy)
            {wygrana = i;}

            if(tabelaZnakow[0][0] == znakPomocniczy && tabelaZnakow[1][1] == znakPomocniczy && tabelaZnakow[2][2] == znakPomocniczy)
            {wygrana = i;}

            if(tabelaZnakow[0][2] == znakPomocniczy && tabelaZnakow[1][1] == znakPomocniczy && tabelaZnakow[2][0] == znakPomocniczy)
            {wygrana = i;}

            znakPomocniczy = 'O';

        }
            if(wygrana == 1)
            {
                //funkcja na wygraną "X"
                Toast.makeText(this,"Gratulacje, wygrały X", Toast.LENGTH_LONG).show();
                czyscPlansze();
            }
            if(wygrana == 2)
            {
                //funkcja na wyrganą "O"
                Toast.makeText(this,"Gratulacje, wygrały O", Toast.LENGTH_LONG).show();
                czyscPlansze();
            }

            if(wygrana == 0 && ruch == 9)
            {
                //funkcja na remis
            Toast.makeText(this,"Niestety... Remis", Toast.LENGTH_LONG).show();
            czyscPlansze();
            }




    }


    public void wcisnietyPrzycisk(View view){

        String buttonID = view.getResources().getResourceEntryName(view.getId());
        tablicaPrzyciskow[ruch] = (Button) findViewById(view.getId());
        tablicaPrzyciskow[ruch].setClickable(false);


        if(gracz == 0)
        {

            znak = 'X';
            jakiPrzycisk1 = Integer.parseInt(String.valueOf(buttonID.charAt(6)));
            jakiPrzycisk2 = Integer.parseInt(String.valueOf(buttonID.charAt(8)));
            //tablicaPrzyciskow[jakiPrzycisk1-1][jakiPrzycisk2-1] = przycisk;
            tablicaPrzyciskow[ruch].setText("X");
            tabelaZnakow[jakiPrzycisk1-1][jakiPrzycisk2-1] = znak;
            gracz = 1;
            ruch++;

        }
        else
        {

            znak = 'O';
            jakiPrzycisk1 = Integer.parseInt(String.valueOf(buttonID.charAt(6)));
            jakiPrzycisk2 = Integer.parseInt(String.valueOf(buttonID.charAt(8)));
            //tablicaPrzyciskow[jakiPrzycisk1-1][jakiPrzycisk2-1] = przycisk;
            tablicaPrzyciskow[ruch].setText("O");
            tabelaZnakow[jakiPrzycisk1-1][jakiPrzycisk2-1] = znak;
            gracz = 0;
            ruch++;

        }

        if(ruch >= 5)
        {
            czyWygrana();
        }

    }
}