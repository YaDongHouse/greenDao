package com.dong.green.dao;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.dong.green.dao.dataBase.bean.Order;
import com.dong.green.dao.dataBase.bean.Shop;
import com.dong.green.dao.dataBase.bean.User;
import com.dong.green.dao.dataBase.db.DaoSession;
import com.dong.green.dao.dataBase.db.OrderDao;
import com.dong.green.dao.dataBase.db.ShopDao;
import com.dong.green.dao.dataBase.db.UserDao;

import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText orderUid;
    private EditText shopIdForOrder;
    private EditText userId;
    private ImageButton add;
    private ImageButton query;
    private DaoSession daoSession;
    private UserDao userDao;
    private ShopDao shopDao;
    private OrderDao orderDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        initView();
    }

    private void initView() {
        orderUid = findViewById(R.id.edit_order_uid);
        shopIdForOrder = findViewById(R.id.edit_shop_shopIdForOrder);
        userId = findViewById(R.id.edit_user_id);
        add = findViewById(R.id.btn_add);
        query = findViewById(R.id.btn_query);
        add.setOnClickListener(this);
        query.setOnClickListener(this);
        daoSession = App.getDaoSession();
        App.setDbDebug(true);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_add:
                addData();
                break;
            case R.id.btn_query:
                queryData();
                break;
                default:
        }
    }

    /**
     * 增加数据
     */
    private void addData(){
        userDao = daoSession.getUserDao();
        shopDao = daoSession.getShopDao();
        orderDao = daoSession.getOrderDao();
        User user = new User(null,"李永见","18655897896",2,"0.85");
        userDao.insert(user);
        Order order = new Order(null,"net-123456",1,"pay_code-123456",user.getId());
        orderDao.insert(order);
        Shop shop = new Shop(null,"商品1","00000001","5.1",1,order.getId());
        Shop shop2 = new Shop(null,"商品2","00000001","5.2",2,order.getId());
        Shop shop3 = new Shop(null,"商品3","00000001","5.3",3,order.getId());
        Shop shop4 = new Shop(null,"商品4","00000001","5.4",4,order.getId());
        shopDao.insertInTx(shop,shop2,shop3,shop4);
    }

    private static final String TAG = "MainActivity";

    /**
     * 查询数据
     */
    private void queryData(){
        List<Order> orders = orderDao.loadAll();
        for (Order order : orders) {
            Log.e(TAG, "queryData: order:"+order );
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
