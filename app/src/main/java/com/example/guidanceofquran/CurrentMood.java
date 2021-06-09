package com.example.guidanceofquran;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class CurrentMood extends AppCompatActivity {

    Spinner spinner;
    EditText search;

    String [] Happy= {"أُوْلَـئِكَ عَلَى هُدًى مِّن رَّبِّهِمْ وَأُوْلَـئِكَ هُمُ الْمُفْلِحُونَ\",\n" +
            "    \" It is they who follow the guidance [which comes] from their Sustainer; and it is they, they who shall attain to a happy state!\"" +
            "    \"Al-Baqara (The Cow) 2:5\",\n","    \"وَلْتَكُن مِّنكُمْ أُمَّةٌ يَدْعُونَ إِلَى الْخَيْرِ وَيَأْمُرُونَ بِالْمَعْرُوفِ وَيَنْهَوْنَ عَنِ الْمُنكَرِ وَأُوْلَـئِكَ هُمُ الْمُفْلِحُونَ\",\n" +
            "    \"and that there might grow out of you a community [of people] who invite unto all that is good, and enjoin the doing of what is right and forbid the doing of what is wrong: and it is they, they who shall attain to a happy state!\"" +
            "    \"Al-Imran (The Family of Imran) 3:104\",\n" };

    String [] Love= {"يَمْحَقُ اللّهُ الْرِّبَا وَيُرْبِي الصَّدَقَاتِ وَاللّهُ لاَ يُحِبُّ كُلَّ كَفَّارٍ أَثِيم\",\nٍ"+
            "\" God deprives usurious gains of all blessing, whereas He blesses charitable deeds with manifold increase. [265] And God does not love anyone who is stubbornly ingrate and persists in sinful ways.\""+
            "\"Al-Baqara (The Cow) 2:276\",\n", "بَلَى مَنْ أَوْفَى بِعَهْدِهِ وَاتَّقَى فَإِنَّ اللّهَ يُحِبُّ الْمُتَّقِينَ\",\nَ"+
            "\"Nay, but [God is aware of] those who keep their bond with Him, [59] and are conscious of Him: and, verily, God loves those who are conscious of Him.\""+
            "\"Al-Imran (The Family of Imran) 3:76\",\n"};

    String [] Angry= {" اَلَّذِیۡنَ  یُنۡفِقُوۡنَ  فِی  السَّرَّآءِ  وَالضَّرَّآءِ  وَالۡکٰظِمِیۡنَ  الۡغَیۡظَ  وَالۡعَافِیۡنَ  عَنِ  النَّاسِ  ۗ  وَاللّٰہُ  یُحِبُّ  الۡمُحۡسِنِیۡنَ\",\n "+
            "\"Those who spend in prosperity and adversity, and those who suppress anger and pardon men; and Allah loves those who do good;"+
            "\"(Al-Imran) 3:135 \",\n ", "وَمَنۡ یُّوَلِّہِمۡ یَوۡمَئِذٍ دُبُرَہٗۤ اِلَّا مُتَحَرِّفًا لِّقِتَالٍ اَوۡ مُتَحَیِّزًا اِلٰی فِئَۃٍ فَقَدۡ بَآءَ بِغَضَبٍ مِّنَ اللّٰہِ وَمَاۡوٰٮہُ جَہَنَّمُ ۖ وَبِئۡسَ الۡمَصِیۡرُ\""+
            "\"And whoso turns his back to them on such a day, unless manoeuvring for battle or turning to join another company, he indeed draws upon himself the wrath of Allah, and Hell shall be his abode. And an evil resort it is."+
            "\"Surat Al-'Anfal\",\n"};

    String [] Anxious= {"\"وَلۡیَخۡشَ الَّذِیۡنَ لَوۡ تَرَکُوۡا مِنۡ خَلۡفِہِمۡ ذُرِّیَّۃً ضِعٰفًا خَافُوۡا عَلَیۡہِمۡ فَلۡیَتَّقُوا اللّٰہَ وَلۡیَقُوۡلُوۡا قَوۡلًا سَدِیۡدًا\",\n"+
            "\"And let those fear God who, if they should leave behind them their own weak offspring, would be anxious for them. Let them, therefore, fear Allah and let them say the right word.\""+
            "\"Surah An-Nisa\",\n"};
    String [] Peace= {"وَلاَ تَجْعَلُواْ اللّهَ عُرْضَةً لِّأَيْمَانِكُمْ أَن تَبَرُّواْ وَتَتَّقُواْ وَتُصْلِحُواْ بَيْنَ النَّاسِ وَاللّهُ سَمِيعٌ عَلِيمٌ\",\n"+
            "\"AND DO NOT allow your oaths in the name of God to become an obstacle to virtue and God-consciousness and the promotion of peace between men: [212] for God is all-hearing, all-knowing.\""+
            "\"Al-Baqara (The Cow) 2:224,\n","لَهُمْ دَارُ السَّلاَمِ عِندَ رَبِّهِمْ وَهُوَ وَلِيُّهُمْ بِمَا كَانُواْ يَعْمَلُونَ\",\n"+
            "\"Theirs shall be an abode of peace with their Sustainer; and He shall be near unto them in result of what they have been doing.\""+
            "\"Al-An'am (The Cattle) 6:127,\",\n"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_current_mood);

        spinner = findViewById(R.id.spinner);
        search = findViewById(R.id.ayat);

        spinner.setAdapter(new ArrayAdapter<>(CurrentMood.this, android.R.layout.simple_spinner_dropdown_item, getResources().getStringArray(R.array.Moods)));

        Spinner Spinner_Filter = findViewById(R.id.filter);
        ArrayAdapter<String> Adapter_filter = new ArrayAdapter<String>(CurrentMood.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.Filter));
        Adapter_filter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner_Filter.setAdapter(Adapter_filter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                if (position == 0){
                    Toast.makeText(CurrentMood.this, "Please select a Mood", Toast.LENGTH_SHORT).show();

                }
                else{
                    String mood = parent.getItemAtPosition(position).toString();
                    String state = Spinner_Filter.getSelectedItem().toString();
                        if (mood.equalsIgnoreCase("Happy")) {

                            if (state.equalsIgnoreCase("Complete Quran")) {
                                search.setText("");
                                search.setText(Happy[0] + Happy[1]);
                            }if (state.equalsIgnoreCase("First Half")) {
                                search.setText("");
                                search.setText(Happy[0]);
                            } if (state.equalsIgnoreCase("Second Half")){
                                search.setText("");
                                search.setText(Happy[1]);
                            }
                        }

                    if (mood.equalsIgnoreCase("Love")){
                        if (state.equalsIgnoreCase("Complete Quran")) {
                            search.setText("");
                            search.setText(Love[0] + Love[1]);
                        }if (state.equalsIgnoreCase("First Half")) {
                            search.setText("");
                            search.setText(Love[0]);
                        } if (state.equalsIgnoreCase("Second Half")){
                            search.setText("");
                            search.setText(Love[1]);
                        }
                    }
                    if (mood.equals("Angry")){

                        if (state.equalsIgnoreCase("Complete Quran")) {
                            search.setText("");
                            search.setText(Angry[0] + Angry[1]);
                        }if (state.equalsIgnoreCase("First Half")) {
                            search.setText("");
                            search.setText(Angry[0]);
                        } if (state.equalsIgnoreCase("Second Half")){
                            search.setText("");
                            search.setText(Angry[1]);
                        }
                    }
                    if (mood.equals("Anxious")){

                        if (state.equalsIgnoreCase("Complete Quran")) {
                            search.setText("");
                            search.setText(Anxious[0]);
                        }if (state.equalsIgnoreCase("First Half")) {
                            search.setText("");
                            search.setText(Anxious[0]);
                        } if (state.equalsIgnoreCase("Second Half")){
                            search.setText("");
                            Toast.makeText(CurrentMood.this, "No Ayah found for second half of Holy Quran", Toast.LENGTH_SHORT).show();
                        }
                    }
                    if (mood.equals("Peace")){

                        if (state.equalsIgnoreCase("Complete Quran")) {
                            search.setText("");
                            search.setText(Peace[0] + Peace[1]);
                        }if (state.equalsIgnoreCase("First Half")) {
                            search.setText("");
                            search.setText(Peace[0]);
                        } if (state.equalsIgnoreCase("Second Half")){
                            search.setText("");
                            search.setText(Peace[1]);
                        }
                    }
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
}}