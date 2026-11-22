package com.lxj.xpopupdemo.custom;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.core.widget.NestedScrollView;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.lxj.xpopup.core.BottomPopupView;
import com.lxj.xpopup.util.XPopupUtils;
import com.lxj.xpopupdemo.R;


/**
 * Description:
 * Create by dance, at 2019/5/5
 */
public class PagerBottomPopup extends BottomPopupView {
    public PagerBottomPopup(@NonNull Context context) {
        super(context);
    }

    @Override
    protected int getImplLayoutId() {
        return R.layout.custom_view_pager;
    }

    ViewPager pager;

    @Override
    protected void onCreate() {
        super.onCreate();
        pager = findViewById(R.id.pager);
        pager.setAdapter(new PAdapter());
    }

    @Override
    protected void onShow() {
        super.onShow();
    }

    @Override
    protected void onDismiss() {
        super.onDismiss();
    }

    @Override
    protected int getMaxHeight() {
        return (int) (XPopupUtils.getWindowHeight(getContext())*.85f);
    }

    class PAdapter extends PagerAdapter {
        @Override
        public int getCount() {
            return 6;
        }

        @Override
        public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
            return view == o;
        }

        @Override
        public Object instantiateItem(@NonNull ViewGroup container, int position) {
            NestedScrollView scrollView = new NestedScrollView(container.getContext());
            LinearLayout linearLayout = new LinearLayout(container.getContext());
            linearLayout.setOrientation(LinearLayout.VERTICAL);
            scrollView.addView(linearLayout);
            TextView textView = new TextView(container.getContext());
            textView.setPadding(40,40,40,40);
            textView.setText("2008骞达紝鏂囩珷鍦ㄧ儹鎾墽銆婂鏂椼€嬩腑鍑烘紨鐢蜂簩鍙峰悜鍗楋紝寮曡捣骞挎硾鍏虫敞銆傝繖涔熸槸鏂囩珷鍜屽瀛愰┈浼婄悕鐨勭浜屾鍚堜綔銆?009骞达紝鏂囩珷杩涘叆鐢靛奖灞婏紝涓绘紨绗竴閮ㄧ數褰便€婅蛋鐫€鐬с€嬨€傝鐗囧湪涓婃捣鍥介檯鐢靛奖鑺傛柊鐗囧睍鏄犲崟鍏冨拰涓滀含鍥介檯鐢靛奖鑺傗€滀簹娲查鈥濆崟鍏冭幏濂栥€傛枃绔犱篃鍑富婕旂殑鍖椾含闈掑勾椹澃涓€瑙掕幏寰楃12灞婁笂娴峰浗闄呯數褰辫妭鏈€鍙楀叧娉ㄦ柊浜烘紨鍛樺銆?009骞达紝鏂囩珷涓绘紨鐢佃鍓с€婄埍鍦ㄦ棩鏈堟江銆嬶紝鍙傛紨鐑挱鐢佃鍓с€婅湕灞呫€嬶紝鎴愬姛楗版紨閰嶈灏忚礉锛岀煡鍚嶅害寰楀埌杩涗竴姝ユ彁楂樸€?010骞达紝鏂囩珷涓庢潕杩炴澃鍏卞悓涓绘紨鏂囪壓鐗囥€婃捣娲嬪ぉ鍫傘€嬶紝鏂囩珷楗版紨闈掑勾鑷棴鐥囨偅鑰呭ぇ绂忥紝琚涓烘槸涓浗鐨勨€滆揪鏂眬路闇嶅か鏇尖€濄€傛枃绔犲嚟姝ょ墖鑾峰緱绗?4灞婁腑鍥界數褰卞崕琛ㄥ浼樼鏂颁汉鐢锋紨鍛樺锛岀13灞婁笂娴峰浗闄呯數褰辫妭鏈€浣崇敺涓昏濂栧拰绗?8灞婂寳浜ぇ瀛︾敓鐢靛奖鑺傛渶鍙楀ぇ瀛︾敓娆㈣繋鐢锋紨鍛樺銆傝鐗囪幏寰椾笂娴峰浗闄呯數褰辫妭鈥滈噾鐖靛鈥濓紝涓浗鐢靛奖鍗庤〃濂栦紭绉€鏁呬簨鐗囧鍜岀18灞婂寳浜ぇ瀛︾敓鐢靛奖鑺備汉鏂囧叧鎬€濂栥€傚悓骞达紝鏂囩珷涓绘紨鐢佃鍓с€婇洩璞广€嬶紝璇ュ墽琚悇澶х數瑙嗗彴鍙嶅鎾斁銆傛枃绔犲嚟鍊熷懆鍗浗涓€瑙掕幏寰楃12灞婂洓宸濈數瑙嗚壓鏈妭閲戠唺鐚鐢佃鍓х被鏈€浣崇敺婕斿憳锛岀9灞婁腑鍥介噾楣扮數瑙嗚壓鏈妭鏈€鍏蜂汉姘旂敺婕斿憳鍜岀26灞婁腑鍥界數瑙嗛噾楣板鏈€鍙楄浼楀枩鐖辩敺婕斿憳銆?011骞达紝鏂囩珷鍦ㄦ粫鍗庡饥瀵兼紨銆佹敼缂栬嚜缃戠粶灏忚鐨勭數瑙嗗墽銆婅８濠氭椂浠ｃ€嬩腑鍑烘紨鐢蜂富瑙掑垬鏄撻槼锛岃缃戝弸瑾変负鐏鐢枫€傛枃绔犲湪銆婅８濠氭椂浠ｃ€嬩腑鏇磋韩鍏煎墽鏈瓥鍒掞紝鐗囦腑璁稿缁忓吀鍙拌瘝琚勾杞讳汉鎺ㄥ磭銆傛枃绔犲嚟姝ょ墖鑾峰緱2011鍥藉墽鐩涘吀骞村害鏈€浣崇敺婕斿憳銆傜敱鏂囩珷涓庣櫧鐧句綍涓绘紨锛屾粫鍗庡饥瀵兼紨锛屾敼缂栬嚜缃戠粶灏忚鐨勭數褰便€婂け鎭?3澶┿€嬪湪鍚勫ぇ褰遍櫌涓婃槧锛屽垱閫犱簡灏忔垚鏈數褰辩殑绁ㄦ埧銆傛枃绔犲嚟鐜嬪皬璐变竴瑙掕幏寰楃31灞婂ぇ浼楃數褰辩櫨鑺卞鏈€浣崇敺婕斿憳濂栥€備粬鏄涓€涓幏姝ゆ畩鑽ｇ殑80鍚庣敺婕斿憳銆傚湪鐢靛奖銆婁竾鏈夊紩鍔涖€嬩腑锛屾枃绔犻グ婕斿叾涓竴涓崟鍏冪殑鐢蜂富瑙掗珮娲嬶紝璇ョ墖鍏ュ洿鍔犳嬁澶ц挋鐗瑰埄灏斿浗闄呯數褰辫妭鏈€浣冲奖鐗囥€傛枃绔犺繕鍙傛紨浜嗙數褰便€婄櫧铔囦紶璇淬€嬶紝楗版紨浜嗕竴涓潪甯告姠鐪肩殑閰嶈鑳藉繊銆?012骞达紝鏂囩珷涓绘紨璐哄瞾鐗囥€婁翰瀹惰繃骞淬€嬮グ婕旂敺涓昏寮犻洩浼︺€?013骞达紝鐢辨枃绔犱富婕旂殑鍛ㄦ槦椹扮數褰便€婅タ娓嘎烽檷榄旂瘒銆嬫墦鐮村崕璇墖绁ㄦ埧璁板綍锛屾敹鑾峰叏鐞冪エ鎴?.15浜跨編鍏冦€傚悓骞存枃绔犺嚜宸辩粡钀ョ殑褰辫宸ヤ綔瀹?鍚涚锛堝寳浜級褰辫鏂囧寲鏈夐檺鍏徃鍙備笌鎶曡祫鍒朵綔鐨勭涓€閮ㄥ奖瑙嗕綔鍝併€婂皬鐖哥埜銆嬪湪澶ч檰鍥涘ぇ鍗榛勯噾妗ｆ挱鍑恒€傛枃绔犲湪璇ュ墽涓笉浠呴グ婕旂敺涓昏浜庢灉锛岃繕鎷呬换瀵兼紨骞跺弬涓庡墽鏈瓥鍒掋€傝繖鏄枃绔犵涓€娆″嚭浠诲婕斻€傛枃绔犲嚟銆婂皬鐖哥埜銆嬭幏2013鍥藉墽鐩涘吀 瑙備紬鍠滅埍鐨勫婕旓紝璇ョ墖鍚屾椂鑾峰緱2013鍥藉墽鐩涘吀鍗佷匠鐢佃鍓у銆傚瀛愰┈浼婄悕鍦ㄧ墖涓グ婕斿コ涓昏锛屽苟鎷呬换鍒剁墖浜恒€?014骞达紝鏂囩珷鍙傛紨濮滄枃瀵兼紨鐨勭數褰便€婁竴姝ヤ箣閬ャ€嬶紝楗版紨涓昏涔嬩竴姝︿竷銆傝鐗囧叆鍥寸65灞婃煆鏋楃數褰辫妭銆?016骞达紝鏂囩珷涓绘紨寮犻粠瀵兼紨鐨勭數瑙嗗墽銆婂皯甯呫€嬮グ婕斿巻鍙蹭汉鐗╁紶瀛﹁壇銆傛枃绔犲嚟姝ょ墖鑾峰緱2017涓浗鐢佃鍓у搧璐ㄧ洓鍏稿勾搴﹀搧璐ㄨ〃婕斿墽鏄熴€傚悓骞翠竷鏈堬紝鐢辨枃绔犵殑鍚涚锛堜笂娴凤級褰辫鏂囧寲鏈夐檺鍏徃鍙備笌鍒朵綔鐨勫枩鍓х埍鎯呯數褰便€婇檰鍨氱煡椹繍銆嬪湪涓浗澶ч檰锛岀編鍥斤紝鍔犳嬁澶э紝婢冲ぇ鍒╀簹鍙婃柊瑗垮叞涓婃槧銆傛枃绔犱笉浠呮媴浠诲婕旓紝杩樺吋浠荤紪鍓с€傛鐗囦互涓皬鎴愭湰鑾峰緱杩?浜跨エ鎴裤€傛枃绔犵殑瀵兼紨椋庢牸琚竴浜涘奖璇勪汉瑾変负鈥滄枃鎴垮洓瀹濃€?- 鈥滄枟鍢寸毊銆侀婕旀妧銆佹姈鏈虹伒銆佹埑蹇冪獫鈥濄€傛枃绔犲嚟姝ゅ濂充綔鎻愬悕绗崄涔濆眾涓婃捣鍥介檯鐢靛奖鑺備箣浜氭床鏂颁汉濂栨渶浣冲婕斿銆傚悓骞村叓鏈堛€婇檰鍨氱煡椹繍銆嬭幏寰楃40灞婂姞鎷垮ぇ钂欑壒鍒╁皵鍥介檯鐢靛奖鑺備腑鍥界數褰遍摱濂栥€?017骞达紝銆婇檰鍨氱煡椹繍銆嬭幏寰楃31灞婁腑鍥界數褰遍噾楦″涓冮」鎻愬悕 - 鏈€浣冲婕斿濂充綔锛屾渶浣崇敺涓昏锛屾渶浣冲コ涓昏锛屾渶浣崇敺閰嶈锛屾渶浣冲コ閰嶈锛屾渶浣冲綍闊冲拰鏈€浣虫憚褰便€傛渶鍚庢枃绔犺崳鑾锋渶浣冲婕斿濂充綔濂栥€?017骞达紝鏂囩珷鐨勫悰绔癸紙涓婃捣锛夊奖瑙嗘枃鍖栨湁闄愬叕鍙稿弬涓庡埗浣滆皪鎴樺墽銆婂墐鍒€杈圭紭銆嬶紝鏂囩珷鎷呬换瀵兼紨骞堕グ婕旂敺涓昏璁镐粠鑹€傚瀛愰┈浼婁繍鍑烘紨濂充富瑙掋€傛鐗囨墦鐮翠互寰€璋嶆垬鍓х殑濂楄矾锛屼互灏忎汉鐗╃殑鎴愰暱涓轰富绾匡紝鍔犲叆鐖辨儏锛屾帰妗堢瓑鍏冪礌銆傜數瑙嗗墽鎾嚭鍚庯紝鍙ｇ鏀惰鍧囧彇寰楄壇濂界殑鎴愮哗銆傚悓骞翠笁鏈堬紝鏂囩珷閲嶈繑鑸炲彴锛屽嚭婕旂嫭瑙掕瘽鍓с€婃瘡涓€浠剁編濡欑殑灏忎簨銆嬨€傛枃绔犲嚟姝ゅ墽鑾峰緱2017涓婃捣闈欏畨鐜颁唬鎴忓墽璋峰９鎴忓墽澶ц祻骞村害鏈€浣崇敺婕斿憳濂栥€?017骞?1鏈?2鏃ワ紝鐢辨枃绔犵紪鍓у苟瀵兼紨锛岄樋閲屽反宸村垱濮嬩汉椹簯涓绘紨鐨勫井鐢靛奖銆婂姛瀹堥亾銆嬪湪浼橀叿鐙鎾嚭銆傝繖閮ㄥ彧鏈?2鍒嗛挓鐨勭煭鐗囨眹闆嗕簡褰撲粖涓浗椤跺皷鍔熷か鏄庢槦鍜屾鏈寚瀵硷紝鍖呮嫭鏉庤繛鏉帮紝鐢勫瓙涓癸紝鍚翠含锛岃鍜屽钩锛屾椽閲戝疂浠ュ強绋嬪皬涓溿€傜數褰辨挱鍑轰笉鍒颁袱澶╋紝缃戠粶鐐瑰嚮鐜囩獊鐮?.5浜匡紝璇勮閲?.5涓囷紝椤?.1涓囥€?017骞?鏈堝凡缁忕绾︿笂娴疯瘽鍓ц壓鏈腑蹇冪殑鏂囩珷鍑烘紨鐙璇濆墽銆婃瘡涓€浠剁編濡欑殑灏忎簨銆嬶紝鏂囩珷涓€浜烘紨婊?0鍒嗛挓锛屼互缁嗚吇鑰岀湡鎸氱殑琛ㄦ紨锛屽皢姣嶄笌瀛愮殑鎯呮劅瀵瑰硻銆佷翰鎯呬腑鐖变笌鎭ㄧ殑鎸ｆ墡锛屽睍鐜板緱娣嬫紦灏借嚧銆傝繖鏄竴閮ㄦ垚闀跨殑鐙鎴忥紝鏂囩珷浠ユ敹鏀捐嚜濡傜殑琛ㄦ紨锛屼綋鐜颁簡蹇ч儊鐨勮瘲鎰忥紝鑽ｈ幏2017骞翠笂娴烽潤瀹夌幇浠ｆ垙鍓ц胺鈥滃９鎴忓墽澶ц祻鈥濆勾搴︽渶浣崇敺婕斿憳銆?018骞?0鏈?8鏃ュ埌11鏈?鏃ワ紝鏂囩珷棰嗚涓绘紨涓痉鍚堜綔璇濆墽銆婅尪棣嗐€嬨€傝繖閮ㄨ瘽鍓х敱钁楀悕鍏堥攱瀵兼紨瀛熶含杈夋墽瀵硷紝寰峰浗鐭ュ悕鎴忓墽鏋勪綔濉炲反鏂拏瀹夆€㈠嚡鎾ゆ媴浠绘垙鍓ф瀯浣溿€傝繖鐗堛€婅尪棣嗐€嬪湪涔岄晣鎴忓墽鑺傛垚涓哄紑骞曡瘽鍓э紝寮€绁ㄤ粎涓夊垎閽燂紝4400寮犵エ鍗冲憡鍞絼銆傛枃绔犲湪鍓т腑鏈夊ぇ娈电垎鍙戝紡鐙櫧锛屼粬浠ュ骞寸殑琛ㄦ紨鍔熷簳鍜岃壓鏈兘閲忕殑绉疮锛岀敤鑷敱鐪熷疄鐨勮〃杈惧緛鏈嶅湪鍦鸿浼椼€傝繖鏄枃绔犲拰鑸炲彴鐨勪翰瀵嗘帴瑙︼紝鏇存槸浠栧琛ㄦ紨鍜岀粡鍏哥殑鑷存暚銆?);
            textView.setTextSize(16);
            textView.setGravity(Gravity.CENTER);
            linearLayout.addView(textView);
            ImageView imageView = new ImageView(container.getContext());
            imageView.setImageResource(R.mipmap.ic_launcher);
            linearLayout.addView(imageView);
            container.addView(scrollView);
            return scrollView;
        }

        @Override
        public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
            container.removeView((View) object);
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return String.valueOf(position);
        }
    }
}

