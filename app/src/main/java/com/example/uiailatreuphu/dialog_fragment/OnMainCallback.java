package com.example.uiailatreuphu.dialog_fragment;

public interface OnMainCallback {
    void showFrg(String sourceTag,String tag, boolean isMoveBack);
    void showFrg(String sourceTag,String tag,Object data, boolean isMoveBack);

    void closeApp();
}
