package com.android.roboteam.roboteam.bluetooth;


import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.android.roboteam.roboteam.R;

import app.akexorcist.bluetotohspp.library.BluetoothState;
import app.akexorcist.bluetotohspp.library.DeviceList;


/**
 * Created by josevelasquez on 24/06/17.
 */

//public class BaseActivity extends AppCompatActivity {
public class BaseActivity extends AppCompatActivity implements BluetoothController.ConnectedListener {

    private ProgressDialog dialog;
    private BluetoothController bluetoothController;


    public void sendMessage(String message) {
        bluetoothController.sendMessage(message);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bluetoothController = new BluetoothController(this);
        bluetoothController.setConnectedListener(this);
        bluetoothController.checkBluetoothState(this);

    }

    @Override
    protected void onResume() {
        super.onResume();
        if (bluetoothController.isBluetoothConnected()) {
            hideProgressDialog();
        }
    }

    @Override
    public void loadDeviceList() {
        Intent intent = new Intent(this, DeviceList.class);
        startActivityForResult(intent, BluetoothState.REQUEST_CONNECT_DEVICE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case BluetoothState.REQUEST_CONNECT_DEVICE:
                if (resultCode == Activity.RESULT_OK) {
                    bluetoothController.connectToBluetoothDevice(data);
                } else {
                    finish();
                }
                break;
            case BluetoothState.REQUEST_ENABLE_BT:
                if (resultCode == Activity.RESULT_OK) {
                    bluetoothController.connectToBluetoothService();
                } else {
                    finish();
                }
                break;
        }
    }

    // ...

    void showProgressDialog() {
        //dialog = ProgressDialog.show(this, "", "Plase wait",true);//getString(R.string.please_wait), true);
        dialog = ProgressDialog.show(this, "", getString(R.string.please_wait), true);

    }

    public void hideProgressDialog() {
        if (null != dialog) dialog.hide();
    }

    @Override
    public void onDeviceConnected() {

    }

    @Override
    public void onDeviceDisconnected() {

    }

    @Override
    public void onDeviceConnectionFailed() {

    }

}