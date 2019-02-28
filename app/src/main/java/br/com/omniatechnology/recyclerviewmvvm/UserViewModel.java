package br.com.omniatechnology.recyclerviewmvvm;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.text.Editable;
import android.util.Log;

public class UserViewModel extends BaseObservable implements UserActivityContract{

     public User user;

    @Bindable
    public String toastMessage;

    @Bindable
    public boolean isSaveSuccess;


    public void setSaveSuccess(boolean saveSuccess) {
        this.isSaveSuccess = saveSuccess;
        notifyPropertyChanged(BR.isSaveSuccess);
    }

    public UserViewModel(){
     }


    public void setToastMessage(String message){
        this.toastMessage = message;
        notifyPropertyChanged(BR.toastMessage);
    }



    @Override
    public void afterNomeTextChanged(Editable editable) {
        user.setNome(editable.toString());
    }

    @Override
    public void afterEmailTextChanged(Editable editable) {
        user.setEmail(editable.toString());
    }




    @Override
    public void save() {
        Log.i("TAG", "showData: "+user.getNome()+ " - Email: "+user.getEmail());
        setToastMessage("Salvo com Sucesso: "+user.getNome());
        setSaveSuccess(true);
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }



}
