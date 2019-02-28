package br.com.omniatechnology.recyclerviewmvvm;

import android.text.Editable;

public interface UserActivityContract {

    void save();
    void afterNomeTextChanged(Editable editable);
    void afterEmailTextChanged(Editable editable);

}
