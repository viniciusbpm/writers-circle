import Button from '../../components/button/Button.component';
import NavBar from '../../components/nav-bar/NavBar.component';
import Text from '../../components/text/Text.component';
import Title from '../../components/title/Title.component';
import './index.css';

const BookPageScreen = () => {
  return (
    <div className="book-page-box">
      <NavBar />
      <div className="book-page-content">
        <Title className="book-page-title">
          Lorem ipsum: dolor sit amet, consectetur
        </Title>
        <Text>
          Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam sed risus
          ac enim facilisis posuere. Phasellus ornare dapibus placerat.
          Vestibulum ante ipsum primis in faucibus orci luctus et ultrices
          posuere cubilia curae; Nullam nec lectus consectetur, molestie tortor
          in, auctor sapien. Curabitur sagittis faucibus neque, at sollicitudin
          risus accumsan at. Vivamus dui nisi, convallis tempor sodales at,
          pulvinar fermentum ipsum. Vivamus ac vehicula dui. Aenean tincidunt
          eget lectus vel iaculis. Duis vitae laoreet ante. Vivamus sem quam,
          laoreet vitae velit non, auctor consequat purus. Vivamus bibendum erat
          in malesuada porta. Sed vel mauris sem. Phasellus justo mi, volutpat
          non eros vel, dictum luctus nulla. Nulla vitae libero condimentum,
          accumsan lorem in, fermentum risus. Sed vulputate et lectus in
          fringilla. Etiam vehicula leo in nisi ornare auctor. Aliquam venenatis
          eleifend eros interdum consequat. Fusce aliquet elementum pulvinar.
          Etiam vitae tincidunt mauris. Sed tincidunt libero leo, sed mollis
          turpis hendrerit a. Integer ullamcorper lorem justo, non vehicula
          ipsum cursus vel. Nunc sit amet est ut leo facilisis tempor maximus eu
          velit. Aenean porta leo nec metus sollicitudin fermentum. Nam pretium
          sagittis maximus. Nullam dolor ligula, viverra tempor viverra in,
          condimentum non nulla. Aenean vel suscipit arcu. Nam a elit
          condimentum, molestie odio nec, blandit erat. Pellentesque ac augue
          non felis sollicitudin accumsan. Aliquam risus ante, tincidunt sed
          mauris eu, sodales placerat enim. Donec felis nibh, auctor vel felis
          quis, sollicitudin condimentum neque. Nunc lacinia leo ac nisl
          malesuada, nec sodales lorem mattis. Etiam bibendum mauris sed tellus
          tempor cursus. Donec bibendum augue ut ligula vehicula, nec tincidunt
          ligula efficitur. Phasellus sit amet laoreet erat. Praesent libero
          nisl, pulvinar eget aliquet non, finibus nec nibh. Morbi porta ex non
          nisl posuere fermentum. Aliquam a quam euismod, luctus dui non, dictum
          velit. Ut scelerisque purus libero, id suscipit tortor gravida
          euismod. Nunc mollis nisl sit amet lacus auctor tempus. Curabitur
          pharetra orci vel ligula porttitor, nec vulputate nisi suscipit. Duis
          sagittis libero nec maximus maximus. In at porta sem, in tempus
          tellus. Etiam non finibus dui, at euismod urna. Phasellus tempus ex in
          purus hendrerit commodo. Orci varius natoque penatibus et magnis dis
          parturient montes, nascetur ridiculus mus. Ut condimentum velit ut
          orci volutpat hendrerit. Aliquam quis ex vitae magna auctor auctor.
          Nullam tincidunt faucibus luctus. Sed a nunc turpis. Praesent
          tristique sollicitudin nulla in tincidunt. Maecenas ac est tempus
          metus commodo vestibulum ut sed erat. Class aptent taciti sociosqu ad
          litora torquent per conubia nostra, per inceptos himenaeos. Donec
          molestie nisl vitae vulputate porta. Nullam feugiat malesuada mauris,
          vel porttitor ipsum vestibulum nec. Aliquam porttitor, mauris nec
          tincidunt porta, lacus sem ornare libero, nec imperdiet quam nulla eu
          orci. Nam in sapien sit amet quam venenatis consectetur. In egestas
          libero vel nunc blandit, et sollicitudin libero suscipit. Donec
          sollicitudin tempus purus a tincidunt. Duis sapien risus, facilisis a
          efficitur vel, mattis non quam. Quisque ac euismod diam. Phasellus
          iaculis semper laoreet. Donec posuere eleifend rhoncus. Donec et augue
          eget orci pulvinar egestas. Aliquam erat volutpat. Suspendisse a eros
          pulvinar, pharetra lacus ac, scelerisque justo. Aenean mauris nisi,
          auctor id urna eu, scelerisque molestie diam. Pellentesque vehicula
          lorem non ligula mollis lacinia. Pellentesque ultricies congue sem, id
          luctus augue accumsan at. Maecenas ut dolor eu ipsum convallis ornare
          eu nec nulla. Donec facilisis mi feugiat turpis hendrerit, molestie
          aliquet ipsum mattis.
        </Text>
        <div className="book-page-buttons">
          <Button type="primary" className="book-page-button">
            Página anterior
          </Button>
          <Button type="primary" className="book-page-button">
            Próxima página
          </Button>
        </div>
      </div>
    </div>
  );
};

export default BookPageScreen;
